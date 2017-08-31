package com.shop.utils;

import java.util.List;

/**
 * 分页类的封装
 * @author think
 *
 */
public class PageBean<T> {
	private Integer page;
	private Integer totalCount;//总记录数
	private Integer totalPage;//总页数
	private Integer limit;//每页显示的记录数
	private List<T> list;//每页显示数据的集合
	//可以对各种类型进行分页
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	

	
}
