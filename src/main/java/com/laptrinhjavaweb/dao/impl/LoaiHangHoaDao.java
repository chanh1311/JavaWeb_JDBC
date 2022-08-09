package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.MapperRow.LoaiHangHoaMapper;
import com.laptrinhjavaweb.dao.ILoaiHangHoaDao;
import com.laptrinhjavaweb.model.LoaiHangHoaModel;


public class LoaiHangHoaDao extends AbstractDao<LoaiHangHoaModel> implements ILoaiHangHoaDao{

	@Override
	public List<LoaiHangHoaModel> findAll() {
		String sql = "Select * From LoaiHangHoa";
		return query(sql, new LoaiHangHoaMapper());
	}

	@Override
	public LoaiHangHoaModel findOne(int MaLoaiHang) {
		String sql = "Select * From LoaiHangHoa where MaLoaiHang = ?";
		List<LoaiHangHoaModel> listLoaiHang = query(sql, new LoaiHangHoaMapper(),MaLoaiHang);
		return listLoaiHang == null || listLoaiHang.isEmpty() ? null : listLoaiHang.get(0);
		
	}
	
}
