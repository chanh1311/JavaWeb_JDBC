package com.laptrinhjavaweb.model;

public class KhachHangModel extends AbstractModel<KhachHangModel> {
	private String diaChi;
	private String soDienThoai;
	private long mskh;
	private String hoTenKH;
	private String userName;
	private int trangThai;
	private int ma_Chucvu;
	private ChucVuModel chucVu = new ChucVuModel();
	private String matKhau;
	
	public long getMskh() {
		return mskh;
	}
	public void setMskh(long mskh) {
		this.mskh = mskh;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getMa_Chucvu() {
		return ma_Chucvu;
	}
	public void setMa_Chucvu(int ma_Chucvu) {
		this.ma_Chucvu = ma_Chucvu;
	}
	public ChucVuModel getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVuModel chucVu) {
		this.chucVu = chucVu;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	
	
	
}
