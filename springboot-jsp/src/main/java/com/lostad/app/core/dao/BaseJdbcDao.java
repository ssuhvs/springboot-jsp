/**
 * 
 */
package com.lostad.app.core.dao;

import java.util.List;
import java.util.Map;

/**
 * 使用sql进行复杂查询
 * @author sszvip
 *
 */
public interface BaseJdbcDao {
	public <T> List<T> queryListBySql(String sql,Class<T> c,Object ... params);
	public List<Map<String,Object>> queryListBySql(String sql,Object ... params);
	
	public int queryCountbySql(String sql, Object ... params);
	public int excuteSql(String sql,Object ... params);

}
