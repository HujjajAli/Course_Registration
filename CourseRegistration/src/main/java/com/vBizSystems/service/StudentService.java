package com.vBizSystems.service;

import com.vBizSystems.dto.Student;

public interface StudentService {
	
	boolean addStudent(Student student);
	boolean updateStudentCourse(Student student);
	Student getStudentByUsername(String username);
	Student getStudentById(int id);
	

}
