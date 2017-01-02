package com.lostad.app.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.lostad.app.demo.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
