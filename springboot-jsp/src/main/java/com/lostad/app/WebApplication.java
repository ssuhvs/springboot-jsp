package com.lostad.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lostad.app.demo.dao.TaskRepository;
import com.lostad.app.demo.models.Task;


@SpringBootApplication
public class WebApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		taskRepository.save(new Task("Task1","Description about task 1", new Date(), false));
		taskRepository.save(new Task("Task2","Description about task 2", new Date(), false));
		taskRepository.save(new Task("Task3","Description about task 3", new Date(), false));
	}
}
