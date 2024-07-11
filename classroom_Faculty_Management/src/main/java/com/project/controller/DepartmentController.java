package com.project.controller;

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
	    private DepartmentService service;
	  
	  @PostMapping("/insertdata")
	  public String insertdata(@RequestBody Department department) {
		  return service.insertdata(department);
	  }

	    @GetMapping
	    public List<Department> getAllDepartments(Department department) {
	        return service.getAllDepartments(department);
	    }

	    @GetMapping("/{id}")
	    public Department getDepartmentById(@PathVariable Long id) {
	        return service.getDepartmentById(id);
	    }

	    @PostMapping
	    public Department createDepartment(@RequestBody Department department) {
	        service.createDepartment(department);
	        return department;
	    }

	    @PutMapping("/{id}")
	    public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
	        Department department = service.getDepartmentById(id);
	        if (department != null) {
	            department.setName(departmentDetails.getName());
	            service.updateDepartment(department);
	        }
	        return department;
	    }

	    @DeleteMapping("/{id}")
	    public String deleteDepartment(@PathVariable Long id) {
	       return service.deleteDepartment(id);
	    }
	}


