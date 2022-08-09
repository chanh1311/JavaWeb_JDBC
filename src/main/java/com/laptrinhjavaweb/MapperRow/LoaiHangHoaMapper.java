package com.laptrinhjavaweb.MapperRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.laptrinhjavaweb.model.LoaiHangHoaModel;

public class LoaiHangHoaMapper implements RowMapper<LoaiHangHoaModel>{

	@Override
	public List<LoaiHangHoaModel> mapRow(ResultSet resultSet) {
		List<LoaiHangHoaModel> results = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				LoaiHangHoaModel row = new LoaiHangHoaModel();
				row.setMaLoaiHang(resultSet.getInt("MaLoaiHang"));
				row.setTenLoaiHang(resultSet.getString("TenLoaiHang"));
				
				results.add(row);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
}
