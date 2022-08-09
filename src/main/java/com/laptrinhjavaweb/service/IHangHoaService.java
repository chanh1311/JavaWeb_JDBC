package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.HangHoaModel;
import com.laptrinhjavaweb.pagging.Pageable;

public interface IHangHoaService {
	List<HangHoaModel> findHangHoaByGia(long gia);

	HangHoaModel save(HangHoaModel hangHoa);
	HangHoaModel update (HangHoaModel hangHoa);
	void delete(Long ids[]);
	List<HangHoaModel> findAll(Pageable pageAble);
	Integer getToTalItems();
	HangHoaModel findOne(Long mshh);
	
}
