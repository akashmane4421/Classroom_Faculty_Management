package com.project.dao;

import java.awt.desktop.UserSessionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Masseges;
import com.project.entity.Course;

@Repository
public class CourseDao {

	private static final Serializable courseId = null;
	@Autowired
	SessionFactory factory;

	public boolean createCourse(Course course) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(course);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public ArrayList<Course> getAllCourses() {
		ArrayList<Course> clist = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Course.class);
			clist = (ArrayList<Course>) criteria.list();
			transaction.commit();
			session.close();
			return clist;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public List<Course> getCourseById(Long courseId) {
		List<Course> courses = null;
		try {
			Session session = factory.openSession();
			courses = (List<Course>) session.get(Course.class, courseId);
			session.close();
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public boolean updateCourse(Course courseDetails, Long courseId) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Course course = session.load(Course.class, courseId);
			if (course != null) {
				course.setCourseName(courseDetails.getCourseName());
				session.update(course);
			}
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;

	}

	public boolean deleteCourse(Long courseId) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Course course = session.load(Course.class, courseId);
			session.delete(course);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

}
