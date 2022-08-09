package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.LoaiHangHoaModel;

public interface ILoaiHangHoaService {
	List<LoaiHangHoaModel> findAll();
	
	LoaiHangHoaModel findOne(int MaLoaiHang);
}
