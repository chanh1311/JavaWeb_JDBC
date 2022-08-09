package com.laptrinhjavaweb.MapperRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.model.ChucVuModel;
import com.laptrinhjavaweb.model.KhachHangModel;

public class KhachHangMapper implements RowMapper<KhachHangModel> {

	@Override
	public List<KhachHangModel> mapRow(ResultSet resultSet) {
		List<KhachHangModel> results = new ArrayList<>();
		// get tung row
		try {
			while(resultSet.next()) {
				KhachHangModel row = new KhachHangModel();
				row.setMskh(resultSet.getLong("MSKH"));
				row.setHoTenKH(resultSet.getString("HoTenKH"));
				row.setMatKhau(resultSet.getString("MatKhau"));
				row.setDiaChi(resultSet.getString("DiaChi"));
				row.setSoDienThoai(resultSet.getString("SoDienThoai"));
				row.setUserName(resultSet.getString("Username"));
				row.setMa_Chucvu(resultSet.getInt("Ma_ChucVu"));
				row.setTrangThai(resultSet.getInt("TrangThai"));
				ChucVuModel chucVu = new ChucVuModel();
				try {
					
					chucVu.setTenChucVu(resultSet.getString("TenChucVu"));
					chucVu.setMoTaChucVu(resultSet.getString("MoTaChucVu"));
					row.setChucVu(chucVu);
					
					results.add(row);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			return null;
		}
		return results;
	}

}
