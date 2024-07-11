package com.project.dao;

import java.awt.desktop.UserSessionListener;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Course;

@Repository
public class CourseDao {
	
	@Autowired
	SessionFactory factory;

	public Course createCourse(Course course) {

		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(course);
		
		tx.commit();
		session.close();
		
		return course;
	}

	public List<Course> getAllCourses(Course course) {
		Session session=factory.openSession();
		Criteria c=session.createCriteria(Course.class);
		List<Course> clist=(List<Course>) c.list();
		session.close();
		return clist;
	}

	public Course getCourseById(Long id) {
		
		Session session=factory.openSession();
		
		Course course=session.get(Course.class, id);
		return course;
	}

	public Course updateCourse(Course course) {

		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.update(course);
		
		tx.commit();
		session.close();
		return course;
	}

	public String deleteCourse(Long id) {

		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Course course =session.load(Course.class, id);
		
		session.delete(course);
		
		tx.commit();
		session.close();
		return "Data Delete Successfully";
	}

}
