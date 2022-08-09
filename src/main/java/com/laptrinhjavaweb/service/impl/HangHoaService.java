package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IHangHoaDao;
import com.laptrinhjavaweb.dao.ILoaiHangHoaDao;
import com.laptrinhjavaweb.model.HangHoaModel;
import com.laptrinhjavaweb.model.LoaiHangHoaModel;
import com.laptrinhjavaweb.pagging.Pageable;
import com.laptrinhjavaweb.service.IHangHoaService;

@ManagedBean
public class HangHoaService implements IHangHoaService {
	
	
	@Inject
	private IHangHoaDao hangHoaDao;
	
	@Inject
	private ILoaiHangHoaDao loaiHangHoaDao;

	@Override
	public List<HangHoaModel> findHangHoaByGia(long gia) {
		return hangHoaDao.findHangHoaByGia(gia);
	}

	@Override
	public HangHoaModel save(HangHoaModel hangHoa) {
		
		Long id = hangHoaDao.save(hangHoa);
		HangHoaModel hangHoaModel = hangHoaDao.findOne(id);
		return hangHoaModel;
		
	}

	@Override
	public HangHoaModel update(HangHoaModel hangHoa) {
		HangHoaModel hangHoaOld = hangHoaDao.findOne(hangHoa.getMshh());
		if(hangHoaOld != null) {
			// set nhung cai khong sua
//			hangHoa.setGhiChu(hangHoaOld.getGhiChu());
			
			Boolean check = hangHoaDao.update(hangHoa);
			if(check) {
				HangHoaModel hangHoaModel = hangHoaDao.findOne(hangHoa.getMshh());
				return hangHoaModel;
			}else {
				return null;
			}
		}
		return null;
		
		
		
	}

	@Override
	public void delete(Long[] ids) {
		// delete khoa ngoai
		

		// delete khoa chinh
		for(Long id : ids) {
			hangHoaDao.delete(id);
			
		}
		
	}

	@Override
	public List<HangHoaModel> findAll(Pageable pageAble) {
		return hangHoaDao.findAll(pageAble);
	}

	@Override
	public Integer getToTalItems() {
		return hangHoaDao.getToTalItems();
	}

	@Override
	public HangHoaModel findOne(Long mshh) {
		HangHoaModel hangHoa = hangHoaDao.findOne(mshh);
		LoaiHangHoaModel loaiHangHoa = loaiHangHoaDao.findOne(hangHoa.getMaLoaiHang());
		hangHoa.setTenLoaiHang(loaiHangHoa.getTenLoaiHang());
		return hangHoa;
	}

	

	
	
}
