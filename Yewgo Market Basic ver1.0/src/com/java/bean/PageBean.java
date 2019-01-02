package com.java.bean;

import java.util.List;

public class PageBean<T> {
	List<T>list;                          //ÿҳ��ʾ������
	private int pageNumber;   //��ǰҳ��
	private int pageSize;          //ÿҳ��ʾ������
	private int pageCount;       //������
	private int pageTotal;         //��ҳ��
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
