package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class DatHangModel {
	private long soDonDH;
	private long mskh;
	private long msnv;
	private Timestamp ngayDH;
	private Timestamp ngayGH;
	private boolean trangThai;
	
	
	public long getSoDonDH() {
		return soDonDH;
	}
	public void setSoDonDH(long soDonDH) {
		this.soDonDH = soDonDH;
	}
	public long getMskh() {
		return mskh;
	}
	public void setMskh(long mskh) {
		this.mskh = mskh;
	}
	public long getMsnv() {
		return msnv;
	}
	public void setMsnv(long msnv) {
		this.msnv = msnv;
	}
	public Timestamp getNgayDH() {
		return ngayDH;
	}
	public void setNgayDH(Timestamp ngayDH) {
		this.ngayDH = ngayDH;
	}
	public Timestamp getNgayGH() {
		return ngayGH;
	}
	public void setNgayGH(Timestamp ngayGH) {
		this.ngayGH = ngayGH;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
	
	
}
