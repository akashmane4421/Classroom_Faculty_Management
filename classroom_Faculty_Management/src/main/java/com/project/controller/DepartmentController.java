package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Department;
import com.project.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/insertdata")
	public String insertdata(@RequestBody Department department) {
		return departmentService.insertdata(department);
	}

	@GetMapping
	public ArrayList<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/{departmentId}")
	public List<Department> getDepartmentById(@PathVariable Long departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}

	@PutMapping("/{departmentId}")
	public String updateDepartment(@PathVariable Long departmentId, @RequestBody Department departmentDetails) {
		return departmentService.updateDepartment(departmentDetails, departmentId);
	}

	@DeleteMapping("/{departmentId}")
	public String deleteDepartment(@PathVariable Long departmentId) {
		return departmentService.deleteDepartment(departmentId);
	}
}
