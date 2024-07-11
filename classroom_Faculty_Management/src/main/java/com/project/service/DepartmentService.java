package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.DepartmentDao;
import com.project.entity.Department;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentDao dao;

	public List<Department> getAllDepartments(Department department) {
		return dao.getAllDepartments(department);
	}

	public Department getDepartmentById(Long id) {
		return dao.getDepartmentById(id);
	}

	public String insertdata(Department department) {
		return dao.insertdata(department);
	}
	
	public Department createDepartment(Department department) {
		return dao.createDepartment(department);
	}

	public Department updateDepartment(Department department) {
		return dao.updateDepartment(department);
	}

	public String  deleteDepartment(Long id) {

		return dao.deleteDepartment(id);
	}
}
