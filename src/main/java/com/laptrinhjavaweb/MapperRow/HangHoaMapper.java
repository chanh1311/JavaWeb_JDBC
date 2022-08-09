package com.laptrinhjavaweb.MapperRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.model.HangHoaModel;

public class HangHoaMapper implements RowMapper<HangHoaModel> {
	
	@Override
	public List<HangHoaModel> mapRow(ResultSet resultSet) {
		List<HangHoaModel> results = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				HangHoaModel row = new HangHoaModel();
				row.setMshh(resultSet.getLong("MSHH"));
				row.setTenHH(resultSet.getString("TenHH"));
				row.setMoTaHH(resultSet.getString("MoTaHH"));
				row.setGia(resultSet.getLong("gia"));
				row.setSoLuongHang(resultSet.getInt("SoLuongHang"));
				row.setGhiChu(resultSet.getString("GhiChu"));
				row.setMaLoaiHang(resultSet.getInt("MaLoaiHang"));
				results.add(row);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
