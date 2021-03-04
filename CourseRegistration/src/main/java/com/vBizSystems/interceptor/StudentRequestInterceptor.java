package com.vBizSystems.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StudentRequestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		boolean interceptFlag = true;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("student") == null) {
			System.out.println("My Student Interceptor is Working");
			//request.setAttribute("hello", "yes hello");
			response.sendRedirect(request.getContextPath()+"/home/");
			interceptFlag = false;
		}
		return interceptFlag;
	}
	
	
	
	

}
