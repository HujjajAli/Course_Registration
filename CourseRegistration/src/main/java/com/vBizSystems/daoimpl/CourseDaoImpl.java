package com.vBizSystems.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vBizSystems.dao.CourseDAO;
import com.vBizSystems.dto.Course;

@Repository
public class CourseDaoImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean insertCourse(Course course) {
		boolean b = true;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(course);
			b = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	@Transactional
	public Course getCourse(int id) {
		Course course = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			course =  session.get(Course.class, id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return course;
	}

}
