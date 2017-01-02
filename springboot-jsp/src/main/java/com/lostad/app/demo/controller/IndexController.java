package com.lostad.app.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lostad.app.core.exception.ServiceException;
import com.lostad.app.core.util.CurrentUserUtils;
import com.lostad.app.demo.models.UserEntity;
import com.lostad.app.demo.service.LoginService;
import com.lostad.app.demo.service.TaskService;

/**
 * 
 * @author lance
 * 2014-6-8下午6:47:18
 */
@Controller
public class IndexController {
	private Logger logger = LoggerFactory.getLogger(getClass());
//	@Autowired
//	private HttpSession session;
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/")
    public String index(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        return "login/login";
    }
	
	@GetMapping("/error1")
    public String error1(HttpServletRequest request){
        request.setAttribute("msg", "something wrong!!");
        return "common/error";
    }
	@GetMapping("/login/preLogin")
    public String preLogin(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        return "login/login";
    }
	/**
	 * 登录成功后跳转页面
	 * @author lance
	 * 2014-6-8下午6:50:47
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login/login",method=RequestMethod.POST)
	public String login(UserEntity user, RedirectAttributes redirect){
		try {
			user = loginService.login(user);
		} catch (ServiceException e) {
			logger.debug(e.getMessage());
			redirect.addFlashAttribute("err_code", e.getMessage());
			redirect.addFlashAttribute("user", user);
			return "redirect:/login/login";
		}
		
		CurrentUserUtils.getInstance().serUser(user);
		return "redirect:home/index";
	}
	


    @GetMapping(value = "/login/logout")
    public String allTasks(HttpServletRequest request){
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "login/login";
    }
    
    @GetMapping("/login/register")
    public String newTask(HttpServletRequest request){
        request.setAttribute("mode", "MODE_NEW");
        return "login/register";
    }
    
}
