package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Masseges;
import com.project.entity.Classroom;

@Repository
public class Classroomdao {

	@Autowired
	SessionFactory factory;

	public boolean insertdata(Classroom classroom) {

		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(classroom);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public ArrayList<Classroom> getAllClassrooms() {

		ArrayList<Classroom> classrooms = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Classroom.class);
			classrooms = (ArrayList<Classroom>) criteria.list();
			transaction.commit();
			session.close();
			return classrooms;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public Classroom getClassroomById(long id) {
		try {
			Session session = factory.openSession();
			Classroom classroom = session.get(Classroom.class, id);
			session.close();
			return classroom;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public boolean updateClassroom(Classroom classroomDetails, long classroomId) {
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Classroom classroom = session.get(Classroom.class, classroomId);
			if (classroom != null) {
				classroom.setClassroomName(classroomDetails.getClassroomName());
				session.update(classroom);
			}
			session.update(classroom);
			tx.commit();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public boolean deleteClassroom(long classroomId) {

		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Classroom c = session.load(Classroom.class, classroomId);
			session.delete(c);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}

		return false;
	}

}
