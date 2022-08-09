package com.laptrinhjavaweb.model;

import java.util.List;

import com.laptrinhjavaweb.constant.SystemConstant;

public class AbstractModel<T> {
	
	
	public Integer getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
	private List<T> resultList;
	
	// Tao cac bien nhan tham so dau vao(Phan trang)
	private Integer page = SystemConstant.PAGE_DEFAULT;// page muon toi
	private Integer maxPageItems = SystemConstant.MAXPAGEITEMS_DEFAULT;// so luong item/page
	private Integer totalPages;// Tong so page
	private Integer totalItems;//Tong so Item
	
	// sort
	private String sortBy = SystemConstant.SORTBY_DEFAULT;
	private String sortName = SystemConstant.SORTNAME_DEFAULT;
	
	private String type;
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItems() {
		return maxPageItems;
	}
	public void setMaxPageItems(Integer maxPageItems) {
		this.maxPageItems = maxPageItems;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}


	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
