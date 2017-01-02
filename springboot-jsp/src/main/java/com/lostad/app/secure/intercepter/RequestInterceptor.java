package com.lostad.app.secure.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lostad.app.demo.models.UserEntity;
/**
 * 拦截未登录的用户信息
 * @author lance
 * 2014-6-10下午9:57:20
 */
public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		 //验证用户是否登陆
		String path = request.getRequestURI();
		System.out.println("from Interceptor:###################################"+path);
        Object obj = request.getSession().getAttribute("curr_user");
        if (obj == null || !(obj instanceof UserEntity)) {
            response.sendRedirect(request.getContextPath() + "/login/preLogin");
            return false;
        }
        
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
