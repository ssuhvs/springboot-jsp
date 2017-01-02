package com.lostad.app.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lostad.app.demo.models.BlogEntity;

public interface BlogRepository extends JpaRepository<BlogEntity, Long>{

}
