package com.laptrinhjavaweb.dao;


import java.util.List;

import com.laptrinhjavaweb.MapperRow.RowMapper;

public interface GenericDao<T> {
	List<T> query(String sql,RowMapper<T> rowMapper,Object... parameters);
	Boolean update(String sql, Object... parameters);
	Long Insert(String sql, Object... parameters);
	Integer count(String sql,Object... parameters);
}
