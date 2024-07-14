package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import org.apache.tomcat.util.net.SSLUtilBase;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Masseges;
import com.project.entity.Course;
import com.project.entity.Faculties;
import com.project.entity.Subjects;

@Repository
public class SubjectDao {

	@Autowired
	SessionFactory factory;

	public boolean CreateSubjectData(Subjects subjects) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(subjects);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public ArrayList<Subjects> getAllSubjects() {
		ArrayList<Subjects> subjects = null;
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Subjects.class);
			subjects = (ArrayList<Subjects>) criteria.list();
			session.close();
			return subjects;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public List<Subjects> getDetailsById(long subjectId) {
		List<Subjects> subjects = null;
		try {
			Session session = factory.openSession();
			subjects = (List<Subjects>) session.get(Subjects.class, subjectId);
			session.close();
			return subjects;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public boolean updateSubjects(long subjectId, Subjects subjects) {
		try {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Subjects sublist =session.load(Subjects.class, subjectId);
		if(sublist!=null) {
			sublist.setCourseId(subjects.getCourseId());
			sublist.setSubjectName(subjects.getSubjectName());
			session.update(subjects);
		}
		transaction.commit();
		session.close();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public boolean deleteSubject(long subjectId) {
		try {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Subjects subjects = session.load(Subjects.class, subjectId);
		session.delete(subjects);
		transaction.commit();
		session.close();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}
}
