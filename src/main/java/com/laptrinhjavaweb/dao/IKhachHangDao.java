package com.laptrinhjavaweb.dao;

import java.util.List;

import javax.annotation.ManagedBean;

import com.laptrinhjavaweb.model.KhachHangModel;

@ManagedBean
public interface IKhachHangDao {
	List<KhachHangModel> findAll();
	
	KhachHangModel findByUserNameAndPasswordAndStatus(String userName,String passWord,Integer status);
	
}
