package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;


import com.laptrinhjavaweb.dao.IKhachHangDao;

import com.laptrinhjavaweb.model.KhachHangModel;
import com.laptrinhjavaweb.service.IKhachHangService;

@ManagedBean 
public class KhachHangService implements IKhachHangService {
	// Khai bao interface private
	
	// Cach 2
	@Inject
	private IKhachHangDao khachHangDao;
	
//	// cach 1
//	public KhachHangService(){
//		// Nhung dinh nghia abstract class
//		khachhangDao = new KhachHangDao();
//	}
	

	@Override
	public List<KhachHangModel> findAll() {
		return khachHangDao.findAll();
	}

	@Override
	public KhachHangModel findByUserNameAndPasswordAndStatus(String userName, String passWord, Integer status) {
		KhachHangModel khachHang = new KhachHangModel();
		khachHang = khachHangDao.findByUserNameAndPasswordAndStatus(userName, passWord, status);
		if(khachHang != null) {
			return khachHang;
		}
		System.out.println("Khong tim thay User!");
		return null;
		
	}
	
}
