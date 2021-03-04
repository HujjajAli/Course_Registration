package com.vBizSystems.dao;

import com.vBizSystems.dto.Course;

public interface CourseDAO {
	
	boolean insertCourse(Course course);
	Course getCourse(int id);

}
