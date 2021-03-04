package com.vBizSystems.dao;

import com.vBizSystems.dto.Student;

public interface StudentDAO {
	
	boolean insertStudent(Student student);
	boolean updateStudent(Student student);
	Student getStudent(int id);
	Student getStudentByUsername(String username);
	

}
