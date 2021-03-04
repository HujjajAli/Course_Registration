package com.vBizSystems.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HomeRequestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		boolean interceptFlag = false;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("student") == null) {
			System.out.println("My Home Request Interceptor is Working"+" | "
					+ " Cretion Time "+session.getCreationTime());
			 
			interceptFlag =  true;
		}else {
			interceptFlag = false;
			//response.sendRedirect(request.getContextPath()+"/student/profile/");
			response.sendRedirect(request.getContextPath()+"/student/profile/");
		}
		
		return interceptFlag;
	}
	
	

}
