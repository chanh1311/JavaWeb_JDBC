package com.laptrinhjavaweb.dao;

import java.util.List;

import javax.annotation.ManagedBean;

import com.laptrinhjavaweb.model.HangHoaModel;
import com.laptrinhjavaweb.pagging.Pageable;

@ManagedBean
public interface IHangHoaDao {
	List<HangHoaModel> findHangHoaByGia(long gia);
	Long save(HangHoaModel hangHoa);
	Boolean update(HangHoaModel hangHoa);
	Boolean delete(Long id);
	HangHoaModel findOne(Long id);
	List<HangHoaModel> findAll(Pageable pageAble);
	Integer getToTalItems();
}
