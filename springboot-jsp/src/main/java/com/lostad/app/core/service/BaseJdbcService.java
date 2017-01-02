package com.lostad.app.core.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lostad.app.core.dao.BaseJdbcDao;
import com.lostad.app.core.util.SqlParamUtil;
import com.lostad.app.core.vo.DataGrid;
import com.lostad.app.core.vo.PageInfo;
import com.lostad.app.core.vo.SortDirection;

/**
 * 
 * @author sszvip
 *
 */
@Service
@Transactional
public class BaseJdbcService {
	@Autowired
	protected BaseJdbcDao baseJdbcDao;
	/**
	 * 根据SQL查询单一结果
	 * 
	 * @param
	 * @return
	 */
	public <T> DataGrid datagridsql(String sql,PageInfo pageInfo, T paramObj, List<Object> params) throws Exception {
	
		StringBuffer sb_rows = new StringBuffer();
		StringBuffer sb_count = new StringBuffer();
		// 总量查询的SQL拼接
		sb_count.append("select count(1) from (");
		sb_count.append(sql);
		sb_count.append(") t where 1=1 ");
		// 记录查询的SQL拼接
		sb_rows.append("select * from (");
		sb_rows.append(sql);
		sb_rows.append(") t where 1=1 ");

		/// ssz改为下面的，以支持自定义注解
		StringBuffer sb_condition = SqlParamUtil.genSqlCondition(paramObj, params);
        sb_rows.append(sb_condition);
		sb_count.append(sb_condition);
		int count = baseJdbcDao.queryCountbySql(sb_count.toString(), params.toArray());
		/**
		 * 2、进行排序和分页的拼装
		 */
		// 排序字段 排序方式
		String sort = pageInfo.getSort();
		SortDirection order = pageInfo.getOrder();
		if (sort != null && !sort.equals("")) {
			sb_rows.append(" order by " + sort);
		}
		if (order != null && !order.toString().equals("")) {
			sb_rows.append(" ");
			sb_rows.append(order.toString());
		}
		// 分页
		sb_rows.append(" limit ?,?");
		int pagesize = pageInfo.getRows();
		int start = pageInfo.getStart();
		params.add(start);
		params.add(pagesize);

		List<? extends Object> list = baseJdbcDao.queryListBySql(sb_rows.toString(), paramObj.getClass(),params.toArray());

		DataGrid dataGrid = new DataGrid<>();
		dataGrid.setResults(list);
		dataGrid.setTotal(count);
		dataGrid.setPageInfo(pageInfo);
		
		return dataGrid;
	}
	
	
	public <T> List<T> queryListBySql(String sql,Class<T> c,Object ... params){
		return baseJdbcDao.queryListBySql(sql, c, params);
	}
	
	public List<Map<String,Object>> queryListBySql(String sql,Object ... params){
		return baseJdbcDao.queryListBySql(sql, params);
	}
	
	public int queryCountbySql(String sql, Object ... params){
		return baseJdbcDao.queryCountbySql(sql, params);
	}
	
	public int excuteSql(String sql,Object ... params){
		return baseJdbcDao.excuteSql(sql, params);
	}
	
}
	
	
