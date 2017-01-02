package com.lostad.app.core.vo;

import java.util.List;


/**
 * easyui的datagrid向后台传递参数使用的model
 * 
 * @author
 * 
 */
public class DataGrid<T> {
    private PageInfo pageInfo;
    
	private int total;//总记录数
	private List<T> results;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

}
