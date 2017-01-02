package com.lostvip.test;
     
    import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lostad.app.WebApplication;
import com.lostad.app.core.dao.BaseJdbcDao;
import com.lostad.app.demo.models.Task;
import com.lostad.app.demo.service.TaskService;  
      
    @RunWith(SpringJUnit4ClassRunner.class)  
    @SpringBootTest(classes=WebApplication.class)// 指定spring-boot的启动类  
    public class ApplicationTests {  
        @Autowired  
        private TaskService taskRepository;  
        
        @Autowired  
        private BaseJdbcDao baseJdbcDao;  
       
        @Test  
        public void list() throws Exception {  
        	taskRepository.save(new Task("Task1","Description about task 1", new Date(), false));
        	List count = taskRepository.findAll();
        	System.out.println("+++++++++++++++++++"+count.size());
        	
        	List list = baseJdbcDao.queryListBySql("select * from  t_task ");
        	System.out.println("======================="+list.size());
        	List<Task> list2 = baseJdbcDao.queryListBySql("select * from  t_task ",Task.class);
        	System.out.println("======================="+list2.size());
        }
   }  


    