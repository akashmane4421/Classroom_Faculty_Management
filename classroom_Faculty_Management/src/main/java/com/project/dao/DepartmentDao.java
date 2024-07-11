package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Classroom;
import com.project.entity.Department;

@Repository
public class DepartmentDao {

	@Autowired
	SessionFactory factory;

	public List<Department> getAllDepartments(Department department) {
		Session session = factory.openSession();

//		Transaction tx = session.beginTransaction();

		Criteria query = session.createCriteria(Department.class);

	
		List<Department> dList = (List<Department>) query.list();

//		tx.commit();
		session.close();
		return dList;
	}

	public String insertdata(Department department) {
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(department);

		tx.commit();
		session.close();
		return "data insert sucessfully";
	}

	public Department getDepartmentById(Long id) {
		Session session=factory.openSession();
		Department dept=session.get(Department.class, id);
		return dept;
	}

	public Department createDepartment(Department department) {
		Session session=factory.openSession();
		//Transaction tx=session.beginTransaction();
		
		session.saveOrUpdate(department);
		//tx.commit();
		session.close();
		return department;
	}

	public Department updateDepartment(Department department) {

		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		session.update(department);
		
		tx.commit();
		session.close();
		return department;
	}

	public String deleteDepartment(Long id) {

		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Department dept=session.load(Department.class, id);
		session.delete(dept);
		
		tx.commit();
		session.close();
		return "Data Delete Sucessfully";
	}

}
