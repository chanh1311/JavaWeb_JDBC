package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.MapperRow.HangHoaMapper;
import com.laptrinhjavaweb.dao.IHangHoaDao;
import com.laptrinhjavaweb.model.HangHoaModel;
import com.laptrinhjavaweb.pagging.Pageable;


public class HangHoaDao extends AbstractDao<HangHoaModel> implements IHangHoaDao{

	
	
	@Override
	public List<HangHoaModel> findHangHoaByGia(long gia) {
		String sql = "Select * From HangHoa where gia = ? AND TrangThai = 1";
		return query(sql,new HangHoaMapper(), gia);
	}

	@Override
	public Long save(HangHoaModel hangHoa) {
		String sql = "INSERT INTO hanghoa(TenHH,MoTaHH,Gia,SoLuongHang,GhiChu,MaLoaiHang,TrangThai) VALUES(?,?,?,?,?,?,1)";
		return Insert(sql, hangHoa.getTenHH(),hangHoa.getMoTaHH(),hangHoa.getGia(),hangHoa.getSoLuongHang(),hangHoa.getGhiChu(),hangHoa.getMaLoaiHang());
	}

	@Override
	public Boolean update(HangHoaModel hangHoa) {
		String sql = "UPDATE HangHoa"
				+ " SET TenHH = ?, MoTaHH = ?,gia = ?, SoLuongHang = ?,GhiChu = ?,MaLoaiHang = ?"
				+ " WHERE MSHH = ? AND TrangThai = 1;";
		System.out.println(sql);
		return update(sql, hangHoa.getTenHH(),hangHoa.getMoTaHH(),hangHoa.getGia(), hangHoa.getSoLuongHang(),hangHoa.getGhiChu(),hangHoa.getMaLoaiHang(),hangHoa.getMshh());
	}

	@Override
	public Boolean delete(Long mshh) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE HangHoa");
		sql.append(" SET TrangThai = 0");
		sql.append(" WHERE MSHH = ?");
		return update(sql.toString(), mshh);
	}

	@Override
	public HangHoaModel findOne(Long id) {
		String sql = "Select * From HangHoa where MSHH = ? AND TrangThai = 1";
		List<HangHoaModel> listHangHoa = query(sql,new HangHoaMapper(), id);
		return listHangHoa.isEmpty() || listHangHoa == null  ? null : listHangHoa.get(0);
	}

	@Override
	public List<HangHoaModel> findAll(Pageable pageAble) {
		StringBuilder sql = new StringBuilder("Select * From HangHoa WHERE TrangThai = 1");
		
		// filter
		if(pageAble.getSorter() != null && StringUtils.isNotBlank(pageAble.getSorter().getSortBy()) && StringUtils.isNotBlank(pageAble.getSorter().getSortName())) {
			sql.append(" ORDER BY " + pageAble.getSorter().getSortBy() + " " + pageAble.getSorter().getSortName());
			
		}
		if(pageAble.getOffset() != null && pageAble.getLimit() != null) {
			sql.append(" LIMIT " + pageAble.getOffset() + "," + pageAble.getLimit());
			
		}
		
		return query(sql.toString(),new HangHoaMapper());
	}

	@Override
	public Integer getToTalItems() {
		String sql = "Select count(*) From HangHoa Where TrangThai = 1";
		return count(sql);
	}

	
}