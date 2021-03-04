package com.vBizSystems.controller;




import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vBizSystems.dto.Student;
import com.vBizSystems.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	

	@RequestMapping("/list_courses")
	public ModelAndView getCoursesList(HttpSession session) {
		ModelAndView view = new ModelAndView("profile");
		Student student = (Student)session.getAttribute("student");

		view.addObject("courses", student.getCourses());
		view.addObject("page_view","list-courses");

		return view;
	}

	@RequestMapping("/profile")
	public String studentProfile(){
		return "profile";
	}


	@RequestMapping("/logout")
	public String logout(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute("student",new Student());
		
		model.addAttribute("session_msg_value", "Show");
		model.addAttribute("login_area_msg_1", "Successfully");
		model.addAttribute("login_area_msg_2", " Logged out of System");
		model.addAttribute("alert_css", "alert-success");

		return "index";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@RequestMapping("/testURL")
	public void test_Url(HttpServletResponse response,HttpSession session){
        int refreshTime = (session.getMaxInactiveInterval()-3); 
		response.setIntHeader("Refresh", refreshTime);
		System.out.println("I will be print on every "+refreshTime+" Seconds");
		if(session.getAttribute("student") != null) {
			System.out.println("Session Time :"+refreshTime);
		}else {
			System.out.println("Logged out :Your session has been expired");
		}
	}*/
}
