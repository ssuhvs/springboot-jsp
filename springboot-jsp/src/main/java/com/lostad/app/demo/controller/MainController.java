package com.lostad.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lostad.app.demo.models.Task;
import com.lostad.app.demo.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/")
    public String allTasks(HttpServletRequest request){
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @PostMapping(value="/save")
    public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request){
        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam long id, HttpServletRequest request){
        request.setAttribute("task", taskService.findTask(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam long id, HttpServletRequest request) {
        taskService.delete(id);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }
}
