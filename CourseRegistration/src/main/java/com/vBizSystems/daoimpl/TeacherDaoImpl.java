package com.vBizSystems.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vBizSystems.dao.TeacherDAO;
import com.vBizSystems.dto.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean insertTeacher(Teacher teacher) {
		boolean b= false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(teacher);
			b = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public Teacher getTeacher(int id) {
		// TODO Auto-generated method stub
		Teacher teacher = null;
		Session session = sessionFactory.getCurrentSession();
		teacher         = session.get(Teacher.class,id);
		return teacher;
	}

}
