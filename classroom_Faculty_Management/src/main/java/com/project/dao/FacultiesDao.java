package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Faculties;

@Repository
public class FacultiesDao {

	@Autowired
	SessionFactory factory;

	public String createFaculties(Faculties faculties) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(faculties);
		tx.commit();
		session.close();
		return "Data inserted Successfully..!";
	}

	public List<Faculties> getAllFaculties() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Faculties.class);
		List<Faculties> flist = criteria.list();
		transaction.commit();
		session.close();
		return flist;
	}

	public Faculties getFacultiesById(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculties faculti = session.get(Faculties.class, id);
		transaction.commit();
		session.close();
		return faculti;
	}

	public String updateById(int id, Faculties faculty) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculties faculties = session.get(Faculties.class, id);
		if (faculties != null) {
			faculties.setDepartment_id(faculty.getDepartment_id());
			faculties.setEmail(faculty.getEmail());
			faculties.setName(faculty.getName());
			session.update(faculties);
			transaction.commit();
			session.close();
			return "Data updated successfully!";
		}else {
			return "Something went wrong!";		}
		
	}

	public void deleteFacultiesByid(int id) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Faculties faculties = session.load(Faculties.class, id);
		session.delete(faculties);
		transaction.commit();
		session.close();
	}
}
