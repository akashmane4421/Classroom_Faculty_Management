package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Classroom;

@Repository
public class Classroomdao {
	
	@Autowired
	SessionFactory factory;

	public String insertdata(Classroom classroom) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(classroom);
		tx.commit();
		session.close();
		return "data insert sucessfully";
	}

	public List<Classroom> getAllClassrooms(Classroom classroom) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Classroom");
		
		//List<Classroom> list=(List<Classroom>) session.createQuery("from Classroom",Classroom.class);
		List<Classroom> entityList = (List<Classroom>) query.getResultList();

		
		tx.commit();
		session.close();
		return entityList;
	}

	public Classroom getClassroomById(long id) {
		Session session=factory.openSession();
		Classroom c= session.get(Classroom.class,id);

		return c;
	}

	public String createClassroom(Classroom classroom) {

		Session session=factory.openSession();
		
		session.beginTransaction();
		session.save(classroom);
		return "Classroom create successfully";	
		}

	

	public void updateClassroom(Classroom classroom) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(classroom);
		tx.commit();
		
	}

	public void deleteClassroom(long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	
		Classroom c=session.load(Classroom.class, id);
		session.delete(c);
		tx.commit();		
	}

	
	

	
	
	

}
