package com.vBizSystems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vBizSystems.dao.CourseDAO;
import com.vBizSystems.dao.TeacherDAO;
import com.vBizSystems.dto.Course;
import com.vBizSystems.dto.Teacher;
import com.vBizSystems.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO; 
	@Autowired
	private TeacherDAO teacherDAO;  

	@Override
	@Transactional
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDAO.insertCourse(course);
	}

	@Override
	@Transactional
	public boolean addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDAO.insertTeacher(teacher);
	}

	@Override
	@Transactional
	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		return teacherDAO.getTeacher(id);
	}

	@Override
	@Transactional
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return courseDAO.getCourse(id);
	}

}
