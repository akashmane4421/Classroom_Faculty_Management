package com.project.dao;

import java.io.Serializable;
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
import com.project.entity.Department;

@Repository
public class DepartmentDao {

	@Autowired
	SessionFactory factory;

	public boolean insertdata(Department department) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(department);
			transaction.commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public ArrayList<Department> getAllDepartments() {

		ArrayList<Department> departments = null;
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Department.class);
			departments = (ArrayList<Department>) criteria.list();
			tx.commit();
			session.close();
			return departments;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public List<Department> getDepartmentById(Long departmentId) {
		List<Department> departments = null;
		try {
			Session session = factory.openSession();
			departments = (List<Department>) session.get(Department.class, departmentId);
			session.close();
			return departments;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public boolean updateDepartment(Department departmentDetails, long departmentId) {

		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Department department = session.get(Department.class, departmentId);
			if (department != null) {
				department.setDepartmentName(departmentDetails.getDepartmentName());
				session.update(department);
			}
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;

	}

	public boolean deleteDepartment(Long departmentId) {
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Department dept = session.load(Department.class, departmentId);
			session.delete(dept);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

}
