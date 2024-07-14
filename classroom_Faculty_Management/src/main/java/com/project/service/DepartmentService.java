package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Masseges;
import com.project.dao.DepartmentDao;
import com.project.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDao departmentDao;

	public ArrayList<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

	public List<Department> getDepartmentById(Long departmentId) {
		if (departmentDao.getDepartmentById(departmentId) != null) {
			return departmentDao.getDepartmentById(departmentId);
		} else {
			Masseges.notFoundData();
		}
		return null;
	}

	public String insertdata(Department department) {
		if (departmentDao.insertdata(department)) {
			return Masseges.insertData();
		} else {
			return Masseges.notInsertData();
		}

	}

	public String updateDepartment(Department department, long departmentId) {
		if (departmentDao.updateDepartment(department, departmentId)) {
			return Masseges.updateData();
		} else {
			return Masseges.notUpdateData();
		}
	}

	public String deleteDepartment(Long departmentId) {
		if (departmentDao.deleteDepartment(departmentId)) {
			return Masseges.deleteData();
		} else {
			return Masseges.notDeleteData();
		}
	}
}
