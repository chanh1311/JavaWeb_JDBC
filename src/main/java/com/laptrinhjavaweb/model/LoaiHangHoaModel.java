package com.laptrinhjavaweb.model;

public class LoaiHangHoaModel extends AbstractModel<LoaiHangHoaModel>{
	private int maLoaiHang;
	private String tenLoaiHang;
	
	
	
	public int getMaLoaiHang() {
		return maLoaiHang;
	}
	public void setMaLoaiHang(int maLoaiHang) {
		this.maLoaiHang = maLoaiHang;
	}
	public String getTenLoaiHang() {
		return tenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}
}
