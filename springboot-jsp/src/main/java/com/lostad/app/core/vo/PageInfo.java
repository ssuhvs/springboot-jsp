package com.lostad.app.core.vo;
import java.util.List;



/**
 * easyui的datagrid向后台传递参数使用的model
 * 
 * @author
 * 
 */
public class PageInfo<T> {

	private int page = 1;// 当前页
	private int rows = 10;// 每页显示记录数
	private String sort = null;// 排序字段名
	private SortDirection order = SortDirection.asc;// 按什么排序(asc,desc)
	private String field;// 可选，动态显示的字段
	

	public String getField() {
		return field;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}
	public int getStart() {
		return (getPage() - 1) * getRows();
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public SortDirection getOrder() {
		return order;
	}

	public void setOrder(SortDirection order) {
		this.order = order;
	}
	
}
