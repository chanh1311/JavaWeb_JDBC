package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhjavaweb.MapperRow.RowMapper;
import com.laptrinhjavaweb.dao.GenericDao;

public class AbstractDao<T> implements GenericDao<T>{
	 Connection connectionDB() {
		 ResourceBundle myResources = ResourceBundle.getBundle("db");
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/quanlydathang";
//			String username = "root";
//			String password = "root";
			
			Class.forName(myResources.getString("DriverName"));
			String url = myResources.getString("url");
			String username = myResources.getString("username");
			String password = myResources.getString("password");
			return DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException | SQLException e) {
				return null;
		}
	}// connectionDB

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		PreparedStatement stament = null;
		ResultSet resultSet = null;
		Connection connection = null;
		connection = connectionDB();
		if(connection != null) {
			try {
				// chay cau lenh sql
				stament = connection.prepareStatement(sql);
				setParameter(stament,parameters);
				resultSet = stament.executeQuery();
				// chay thanh cong tra ve
				results = rowMapper.mapRow(resultSet);
				return results;
			} catch (SQLException e) {
				
				// chay that bai tra ve
				return null;
			// du cho chay thanh cong hay that bai deu duoc dong 
			}finally {
				try{
					if(connection != null)
						connection.close();
					if(stament != null)
						stament.close();
					if(resultSet != null)
						resultSet.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}// connection
		return null;	
		
		
	}

	private void setParameter(PreparedStatement stament,Object... parameters) {
		if(parameters != null) {
			for(int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				try {
					if(parameter instanceof Long) {
						stament.setLong(index,(Long)parameter);
					}else if(parameter instanceof String) {
						stament.setString(index,(String)parameter);
					}else if(parameter instanceof Integer) {
						stament.setInt(index,(Integer)parameter);
					}
					else if(parameter instanceof Float) {
						stament.setFloat(index,(Float)parameter);
					}
					else if(parameter instanceof Timestamp) {
						stament.setTimestamp(index,(Timestamp)parameter);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public Boolean update(String sql, Object... parameters) {
		// Dinh nghia cac doi tuong can thiet: stament,connection
		PreparedStatement stament = null;
		Connection connection = connectionDB();
		if(connection != null) {
			try {
				// Run SQL
				connection.setAutoCommit(false);
				
				stament = connection.prepareStatement(sql);
				setParameter(stament, parameters);
				System.out.println(stament);
				stament.executeUpdate();
				
				
				// Commit
				connection.commit();
				
				return true;
			} catch (SQLException e) {
				try {
					// That bai thi Rollback
					connection.rollback();
					return false;
				} catch (SQLException e1) {
					e1.printStackTrace();
					return false;
				}
			}finally {
				try{
					if(connection != null)
						connection.close();
					if(stament != null)
						stament.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
					return false;
				}
			}
			
		}
		
		
		return false;
	}

	@Override
	public Long Insert(String sql, Object... parameters) {
		// Dinh nghia cac doi tuong can thiet: stament,connection
				Long id = null;
				PreparedStatement stament = null;
				ResultSet resultSet = null;
				Connection connection = connectionDB();
				if(connection != null) {
					try {
						// Run SQL
						connection.setAutoCommit(false);
						
						stament = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
						setParameter(stament, parameters);
						stament.executeUpdate();
						// get ID 
						resultSet = stament.getGeneratedKeys();
						if(resultSet.next()) {
							id = resultSet.getLong(1);
						}
						
						// Commit
						connection.commit();
						return id;
					} catch (SQLException e) {
						try {
							// That bai thi Rollback
							connection.rollback();
							return null;
						} catch (SQLException e1) {
							e1.printStackTrace();
							return null;
						}
					}finally {
						try{
							if(connection != null)
								connection.close();
							if(stament != null)
								stament.close();
						}catch(SQLException e2) {
							e2.printStackTrace();
							return null;
						}
					}
					
				}
				
				
				return null;
			}

	@Override
	public Integer count(String sql,Object... parameters) {
		int count = 0;
		PreparedStatement stament = null;
		ResultSet resultSet = null;
		Connection connection = null;
		connection = connectionDB();
		if(connection != null) {
			try {
				// chay cau lenh sql
				stament = connection.prepareStatement(sql);
				resultSet = stament.executeQuery();
				// chay thanh cong tra ve
				if(resultSet.next()) {
					count = resultSet.getInt(1);
				}
				
				return count;
			} catch (SQLException e) {
				
				// chay that bai tra ve
				return 0;
			// du cho chay thanh cong hay that bai deu duoc dong 
			}finally {
				try{
					if(connection != null)
						connection.close();
					if(stament != null)
						stament.close();
					if(resultSet != null)
						resultSet.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}// connection
		return 0;	
		
		
		
		
	}
	
	
}
