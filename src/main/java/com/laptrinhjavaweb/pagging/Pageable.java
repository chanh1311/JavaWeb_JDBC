package com.laptrinhjavaweb.pagging;

import com.laptrinhjavaweb.sort.Sorter;

public interface Pageable {
	public Integer getPage();
	public Integer getOffset();
	public Integer getLimit();
	public Sorter getSorter();
	
}
