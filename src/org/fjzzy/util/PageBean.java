package org.fjzzy.util;

public class PageBean {
	private int pageNow;
	private int pageSize;
	private int pageCount;
	private int rowCount;
	
	public PageBean(int pageSize){
		this.pageSize = pageSize;
	}
	public PageBean(){
		this.pageSize = 10;
	}
	
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}
