/**
 * 
 */
package com.lostad.app.core.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
/**
 * navtive sql 用于复杂查询
 * @author sszvip
 *
 */
@Repository
public class BaseJdbcDaoImpl implements BaseJdbcDao {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 按SQL语句进行查询并返回输入的实体类
	 * 
	 * @param sql
	 * @param params
	 * @param c
	 * @return
	 */
	public <T> List<T> queryListBySql(String sql, Class<T> resultClass, Object... params) {
		Query querys = entityManager.createNativeQuery(sql, resultClass);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				querys.setParameter(i, params[i]);
			}
		}
		
		return querys.getResultList();
	}

	public List<Map<String, Object>> queryListBySql(String sql, Object... params) {
		Query querys = entityManager.createNativeQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				querys.setParameter(i, params[i]);
			}
		}
		return querys.getResultList();
	}

	/**
	 * 按SQL语句进行总数量查询
	 * 
	 * @param sql
	 * @param params
	 * @param c
	 * @return
	 */
	public int queryCountbySql(String sql, Object... params) {
		Query querys = entityManager.createNativeQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				querys.setParameter(i, params[i]);
			}
		}
		int count = ((Number) querys.getSingleResult()).intValue();
		return count;
	}

	@Override
	public int excuteSql(String sql, Object... params) {
		int rows;
		Query query = entityManager.createNativeQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		rows = query.executeUpdate();
		return rows;
	}

}
