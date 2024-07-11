package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.facultyAttendance;
import com.project.service.facultyAttendanceService;

@RestController
@RequestMapping("/api/facultyAttendances")
public class facultyAttendanceController {

	@Autowired
	facultyAttendanceService service;
	
	@PostMapping("/insert")
	public String insertAttendance(@RequestBody facultyAttendance attendance) {
		return service.insertAttendance(attendance);
	}
	
	@GetMapping("/get-all-data")
	public List<facultyAttendance> getAllAttendanceData(facultyAttendance attendance) {
		return service.getAllAttendanceData(attendance);
	}
	
	@GetMapping("/get-data-by-id/{id}")
	public facultyAttendance getAttendanceById(@PathVariable int id) {
		return service.getAttendanceById(id);
	}
	
	
	
}
