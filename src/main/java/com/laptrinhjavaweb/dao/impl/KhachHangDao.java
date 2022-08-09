package com.laptrinhjavaweb.dao.impl;

import java.util.List;



import com.laptrinhjavaweb.MapperRow.KhachHangMapper;
import com.laptrinhjavaweb.dao.IKhachHangDao;
import com.laptrinhjavaweb.model.KhachHangModel;



public class KhachHangDao extends AbstractDao<KhachHangModel> implements IKhachHangDao {
	
		
	@Override
	public List<KhachHangModel> findAll() {
		String sql = "Select * From KhachHang";
		return query(sql, new KhachHangMapper());
	}

	@Override
	public KhachHangModel findByUserNameAndPasswordAndStatus(String userName, String passWord, Integer status) {
		StringBuilder sql = new StringBuilder("Select * From KhachHang as kh");
		sql.append(" INNER JOIN ChucVu as cv");
		sql.append(" ON kh.Ma_ChucVu = cv.MSCV");
		sql.append(" WHERE username = ? AND MatKhau = ? AND TrangThai = ? ");
		
		List<KhachHangModel> listKhachHang = query(sql.toString(), new KhachHangMapper(),userName,passWord,status);
		return listKhachHang == null || listKhachHang.isEmpty() ? null : listKhachHang.get(0);
	}
	

}
