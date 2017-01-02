package com.lostad.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lostad.app.demo.dao.TaskRepository;
import com.lostad.app.demo.models.Task;
import com.lostad.app.demo.models.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginService {

    private final TaskRepository taskRepository;

    @Autowired
    public LoginService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        List<Task> tasks = new ArrayList<>();

        for (Task task : taskRepository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public void delete(long id){
        taskRepository.delete(id);
    }

    public Task findTask(long id){
        return taskRepository.findOne(id);
    }

	public UserEntity login(UserEntity user) {
		return user;
	}
}
