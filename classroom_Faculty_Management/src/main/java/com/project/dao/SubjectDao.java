package com.project.dao;

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

import com.project.entity.Course;
import com.project.entity.Faculties;
import com.project.entity.Subjects;

@Repository
public class SubjectDao {

	@Autowired
	SessionFactory factory;

	public String CreateSubjectData(Subjects subjects) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(subjects);
		transaction.commit();
		session.close();
		return "Data insert Successfully";
	}

	public List<Subjects> getAllSubjects(Subjects subjects) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Subjects.class);
		List<Subjects> list = (List<Subjects>) criteria.list();
		session.close();
		return list;
	}

	public Subjects getDetailsById(long id) {
		Session session = factory.openSession();
		Subjects subjects = session.get(Subjects.class, id);
		session.close();
		return subjects;
	}

	public Subjects updateSubjects(long id, Subjects subjects) {

		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Subjects sublist =session.load(Subjects.class, id);
		if(sublist!=null) {
			sublist.setCourseId(subjects.getCourseId());
			sublist.setName(subjects.getName());
			session.save(subjects);
		}
		return subjects;
	}

	public String deleteSubject(long id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Subjects subjects=session.load(Subjects.class, id);
		session.delete(subjects);
		transaction.commit();
		session.close();
		return "Data delete Successfully";
	}
}
