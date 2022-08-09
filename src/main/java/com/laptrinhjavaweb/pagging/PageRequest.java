package com.laptrinhjavaweb.pagging;

import com.laptrinhjavaweb.sort.Sorter;

public class PageRequest implements Pageable {
	private Integer page;
	private Integer maxPageItems;
	private Sorter sort;
	
	public PageRequest(Integer page, Integer maxPageItems, Sorter sort ) {
		this.page = page;
		this.maxPageItems = maxPageItems;
		this.sort = sort;
		
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(this.page != null && this.maxPageItems != null) {
			Integer offset = (this.page - 1) * this.maxPageItems;
			return offset;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItems;
	}

	@Override
	public Sorter getSorter() {
		if(this.sort != null) {
			return this.sort;
		}
		
		return null;
	}

	
	
	
	
	public void setPage(Integer page) {
		this.page = page;
	}


//	public Integer getMaxPageItems() {
//		return maxPageItems;
//	}
//
//	public void setMaxPageItems(Integer maxPageItems) {
//		this.maxPageItems = maxPageItems;
//	}

	public Sorter getSort() {
		return sort;
	}

	public void setSort(Sorter sort) {
		this.sort = sort;
	}
}
