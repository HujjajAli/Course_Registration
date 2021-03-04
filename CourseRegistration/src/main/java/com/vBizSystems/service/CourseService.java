package com.vBizSystems.service;

import com.vBizSystems.dto.Course;
import com.vBizSystems.dto.Teacher;

public interface CourseService {
	
	boolean addCourse(Course course);
	boolean addTeacher(Teacher teacher);
	Teacher getTeacherById(int id);
	Course  getCourseById(int id);

}
