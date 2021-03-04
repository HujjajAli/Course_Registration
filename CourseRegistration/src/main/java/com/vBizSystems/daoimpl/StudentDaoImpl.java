package com.vBizSystems.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vBizSystems.dao.StudentDAO;
import com.vBizSystems.dto.Student;

@Repository
public class StudentDaoImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean insertStudent(Student student) {
		
		boolean b = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(student);
			b = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	@Transactional
	public Student getStudentByUsername(String username) {
		Student student = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Student> query = session.createQuery("from Student WHERE  username = '"+username+"' ");
			student              = query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	@Transactional
	public boolean updateStudent(Student student) {
		boolean b = false;
		
		try{
			Session session = sessionFactory.getCurrentSession();
			session.update(student);
			b = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}

	@Override
	@Transactional()
	public Student getStudent(int id) {
		Student student = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			student         = session.get(Student.class, id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return student;
	}

}
