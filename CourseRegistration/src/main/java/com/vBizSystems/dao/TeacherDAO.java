package com.vBizSystems.dao;


import com.vBizSystems.dto.Teacher;

public interface TeacherDAO {
	
	
	boolean insertTeacher(Teacher teacher);
	Teacher getTeacher(int id);

}
