package com.laptrinhjavaweb.dao;
import java.util.List;

import javax.annotation.ManagedBean;

import com.laptrinhjavaweb.model.LoaiHangHoaModel;

@ManagedBean
public interface ILoaiHangHoaDao {
	List<LoaiHangHoaModel> findAll();
	LoaiHangHoaModel findOne(int MaLoaiHang);
	
}
