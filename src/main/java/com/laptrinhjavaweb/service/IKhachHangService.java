package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.KhachHangModel;

public interface IKhachHangService {
	List<KhachHangModel> findAll();
	KhachHangModel findByUserNameAndPasswordAndStatus(String userName, String passWord, Integer status);
	
}
