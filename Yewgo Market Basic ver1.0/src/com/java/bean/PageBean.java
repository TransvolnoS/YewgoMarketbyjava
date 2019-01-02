package com.java.bean;

import java.util.List;

public class PageBean<T> {
	List<T>list;                          //每页显示的内容
	private int pageNumber;   //当前页数
	private int pageSize;          //每页显示的条数
	private int pageCount;       //总条数
	private int pageTotal;         //总页数
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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
	public int getPageTotal() {
		return (int)Math.ceil(pageCount*1.0/pageSize);
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	public int getIndex() {
		return (pageNumber-1)*pageSize;
	}
	public PageBean(int pageNumber, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	
}
