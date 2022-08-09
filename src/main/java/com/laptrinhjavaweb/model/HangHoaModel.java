package com.laptrinhjavaweb.model;



public class HangHoaModel extends AbstractModel<HangHoaModel> {
	private long mshh;
	private String tenHH;
	private String moTaHH;
	private long gia;
	private int soLuongHang;
	private String ghiChu;
	private Long ids[];
	
	// add edit
	private int maLoaiHang;
	private String tenLoaiHang;
	
	public HangHoaModel() {
		
	}
	
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public long getMshh() {
		return mshh;
	}
	public void setMshh(long mshh) {
		this.mshh = mshh;
	}
	public String getTenHH() {
		return tenHH;
	}
	public void setTenHH(String tenHH) {
		this.tenHH = tenHH;
	}
	public String getMoTaHH() {
		return moTaHH;
	}
	public void setMoTaHH(String moTaHH) {
		this.moTaHH = moTaHH;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public int getSoLuongHang() {
		return soLuongHang;
	}
	public void setSoLuongHang(int soLuongHang) {
		this.soLuongHang = soLuongHang;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

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
