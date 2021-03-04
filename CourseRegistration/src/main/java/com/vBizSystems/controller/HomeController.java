package com.vBizSystems.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.vBizSystems.dto.Student;
import com.vBizSystems.service.CourseService;
import com.vBizSystems.service.StudentService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	CourseService courseService;
	
	@RequestMapping({"/","/index","/login"})
	public ModelAndView index(HttpSession session){
		ModelAndView view = null;
		
		if(session.getAttribute("student") != null){
			Student student = (Student)session.getAttribute("student");
			view = new ModelAndView("profile");
		}else {
			view = new ModelAndView("index");
			Student student = new Student();
			view.addObject("student",student);
			
		}
		return view;
		
	}
	
	@RequestMapping("/processLogin")
	public ModelAndView login(@ModelAttribute("student")Student student,HttpSession session){
		ModelAndView view = new ModelAndView("profile");
		
		student = studentService.getStudentByUsername(student.getUsername());
		
		
		session.setAttribute("student", student);
		
		return view;
		
	}
	
	
	
	@RequestMapping("/registration")
	public ModelAndView registeration(){
		
		ModelAndView view = new ModelAndView("registration");
		
		Student student = new Student();
		view.addObject("student",student);
		
		
		return view;
	}
	
	@RequestMapping("/registerStudent")
	public ModelAndView registerStudent(@ModelAttribute("student")Student student) {
		ModelAndView view = new ModelAndView("index");
		System.out.println(student);
		
		if(student != null) {
			
			if(student.getStd_name() != null) {
				if(studentService.addStudent(student)){
					
					System.out.println("Saved Successfully");
					view.addObject("session_msg_value", "Show");
					view.addObject("login_area_msg_1", "Successfully");
					view.addObject("login_area_msg_2", " Saved New Student");
					view.addObject("alert_css", "alert-success");
				
				}else {
					System.out.println("Failed To Save");
				}
			}else {
				System.out.println("Failed To Save student was null");
				view.addObject("session_msg_value", "Show");
				view.addObject("login_area_msg_1", "Failed");
				view.addObject("login_area_msg_2", "To Save Student");
				view.addObject("alert_css", "alert-danger");
			}
			
		}
		
		
		
		Student nStudent = new Student();
		view.addObject("student",nStudent);
		
		return view;
	}
	
	@RequestMapping("/registration/valid_username")
	@ResponseBody
	public String usernameValidation(@RequestParam("username")String username){
		String res = "";
		
		Student std = studentService.getStudentByUsername(username);
		
		if(std == null){
			res = "true";
		}else {
			res = "false";
		}
		
		return res;
	}
	
	@RequestMapping({"/validateUsername","login/validateUsername","student/logout/validateUsername","index/validateUsername","/registerStudent/validateUsername"})
	@ResponseBody
	public String validateUsername(@RequestParam("username")String username){
		System.out.println("Username :"+username);
		String res = "";
		Student std = studentService.getStudentByUsername(username);
		
		if(std == null) {
			res = "false";
		}else {
			res = "true";
		}
		
		return res;
	}
	
	@RequestMapping({"/validatePassword","login/validatePassword","student/logout/validatePassword","index/validatePassword","/registerStudent//validatePassword"})
	@ResponseBody
	public String validatePassword(@RequestParam("username")String username,@RequestParam("password")String password){
		String res = "";
		
		Student std = studentService.getStudentByUsername(username);
		System.out.println("Request is Here :Pass :"+password);
		System.out.println("Student is Null "+(std == null));
		if(std == null) {
			System.out.println("Student is Null");
			res = "false";
		}else {
			if(std.getPassword().equals(password)){
				System.out.println("Password is Not Matching");
				res = "true";
			}else { 
				res = "false";
			}
		}
		
		return res;
	}
	
	@RequestMapping("/registration/valid_password_pattern")
	@ResponseBody
	public String validPasswordPattern(@RequestParam("password") String password) {
	/*  (?=.*[0-9]) a digit must occur at least once
		(?=.*[a-z]) a lower case letter must occur at least once
		(?=.*[A-Z]) an upper case letter must occur at least once
		(?=.*[@#$%^&+=]) a special character must occur at least once
		(?=\\S+$) no whitespace allowed in the entire string
		.{5,10} at least 8 characters  */
		
		String res = "";
		String str_ptr =  "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{5,10}";
		System.out.println("Password is :"+password);
		Pattern pattern = Pattern.compile(str_ptr); 
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.find()){
			System.out.println("Password is Valid");
			res = "true";
		}else{
			System.out.println("Password is Not Valid");
			res = "false";
			
		}
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	///------------------Ajax Request Test Code-------------//
	@RequestMapping("/ajaxpage")
	public  ModelAndView ajaxpage(){
		ModelAndView view = new ModelAndView("ajaxtest");
		
		return view;
		
	}
	
	@RequestMapping("/ajaxpage/ajaxresponse")
	@ResponseBody
	public  String ajaxtest(@RequestParam("std") String name){
		
		
		return "Hello "+name;
		
	}
	
	
	@RequestMapping("/saveData")
	public String saveData() {
		
		
		
		/*
		
		Course c1 = courseService.getCourseById(2);
		Course c2 = courseService.getCourseById(3);
		Course c3 = courseService.getCourseById(4);
		
		Student s1  = studentService.getStudentById(1);
		Student s2  = studentService.getStudentById(2);
		
		List<Course> list_of_course1 = new ArrayList<Course>();
		List<Course> list_of_course2 = new ArrayList<Course>();
		
		list_of_course1.add(c3);
		list_of_course1.add(c1);
		
		list_of_course2.add(c1);
		list_of_course2.add(c2);
		list_of_course2.add(c3);
		
		s1.setCourses(list_of_course2);
		s2.setCourses(list_of_course1);
		
		studentService.updateStudentCourse(s1);
		studentService.updateStudentCourse(s2);
		
		
		Teacher t1 = courseService.getTeacherById(4);
		Teacher t2 = courseService.getTeacherById(5);
		
		
		Course c1 = courseService.getCourseById(2);
		Course c2 = courseService.getCourseById(3);
		Course c3 = courseService.getCourseById(4);
		Course c4 = courseService.getCourseById(5);
		Course c5 = courseService.getCourseById(6);
		Course c6 = courseService.getCourseById(7);
		
		
		Student std1 = studentService.getStudentById(1);
		Student std2 = studentService.getStudentById(2);
		Student std3 = studentService.getStudentById(3);
		
		List<Course> list_of_course1 = new ArrayList<Course>();
		List<Course> list_of_course2 = new ArrayList<Course>();
		
		list_of_course1.add(c5);
		list_of_course1.add(c6);
		
		list_of_course2.add(c2);
		list_of_course2.add(c1);
		//list_of_course2.add(c5);
		list_of_course2.add(c6);
		
		std2.setCourses(list_of_course1);
		std1.setCourses(list_of_course1);
		std3.setCourses(list_of_course2);
		
		
		studentService.updateStudentCourse(std1);
		studentService.updateStudentCourse(std3);
		studentService.updateStudentCourse(std2);
		
	*/	
		return ""; 
		
	}
	///------------------Ajax Request Test Code-------------//
}
