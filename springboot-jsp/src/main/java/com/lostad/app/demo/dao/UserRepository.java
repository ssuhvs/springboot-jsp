package com.lostad.app.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lostad.app.demo.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	/**
	 * 根据userName查询
	 * @author lance
	 * 2014-6-11下午11:30:31
	 * @param userName
	 * @return
	 */
	UserEntity findByEmail(String email);
}
