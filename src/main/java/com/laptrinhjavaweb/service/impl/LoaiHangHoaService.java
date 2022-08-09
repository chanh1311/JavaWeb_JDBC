package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ILoaiHangHoaDao;
import com.laptrinhjavaweb.model.LoaiHangHoaModel;
import com.laptrinhjavaweb.service.ILoaiHangHoaService;

@ManagedBean
public class LoaiHangHoaService implements ILoaiHangHoaService {
	
	@Inject
	private ILoaiHangHoaDao loaiHangHoaDao;
	

	@Override
	public List<LoaiHangHoaModel> findAll() {
		return loaiHangHoaDao.findAll();
	}


	@Override
	public LoaiHangHoaModel findOne(int MaLoaiHang) {
		return loaiHangHoaDao.findOne(MaLoaiHang);
	}
	
}
