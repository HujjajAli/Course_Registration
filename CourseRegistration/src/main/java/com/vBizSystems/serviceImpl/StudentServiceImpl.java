package com.vBizSystems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vBizSystems.dao.StudentDAO;
import com.vBizSystems.dto.Student;
import com.vBizSystems.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.insertStudent(student);
	}

	@Override
	@Transactional
	public Student getStudentByUsername(String username) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentByUsername(username);
	}

	@Override
	@Transactional
	public boolean updateStudentCourse(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(student);
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(id);
	}

}
