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
import com.project.entity.Faculties;

@Repository
public class FacultiesDao {

	@Autowired
	SessionFactory factory;

	public boolean createFaculties(Faculties faculties) {
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(faculties);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public ArrayList<Faculties> getAllFaculties() {
		ArrayList<Faculties> faculties = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculties.class);
			faculties = (ArrayList<Faculties>) criteria.list();
			transaction.commit();
			session.close();
			return faculties;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public List<Faculties> getFacultiesById(long facultyId) {
		List<Faculties> faculties = null;
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			faculties = (List<Faculties>) session.get(Faculties.class, facultyId);
			transaction.commit();
			session.close();
			return faculties;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public boolean updateById(long facultyId, Faculties faculty) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Faculties faculties = session.get(Faculties.class, facultyId);
			if (faculties != null) {
				faculties.setDepartmentId(faculty.getDepartmentId());
				faculties.setEmail(faculty.getEmail());
				faculties.setFacultyName(faculties.getFacultyName());
				session.update(faculties);
				transaction.commit();
				session.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public boolean deleteFacultiesByid(long facultyId) {
		try {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculties faculties = session.load(Faculties.class, facultyId);
		session.delete(faculties);
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
