package com.gemptc.entity;

import java.util.ArrayList;
import java.util.List;

//用来表示每一页的数据对象
public class PageBean {
	//当前在第几页
	private int currentPage;  // 第1页 或者是第2页
	//当前页面的商品数
	private int currentCount;  // 分10个  分20个
	//总的商品数量
	private int totalCount;    //数据库里面的总数
	//总的分页数  
	private int totalPage;     // 商品总数  / 每页数量
	
	private List<Integer> pageValue;
	public List<Integer> getPageValue() {
		return pageValue;
	}

	public void setPageValue(List<Integer> pageValue) {
		this.pageValue = pageValue;
	}

	//每页的商品数量
	private List<Product> list = new ArrayList<>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", currentCount=" + currentCount + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
}
