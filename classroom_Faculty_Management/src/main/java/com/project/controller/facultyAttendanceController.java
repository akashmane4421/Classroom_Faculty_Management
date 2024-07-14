package com.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ArrayList<facultyAttendance> getAllAttendanceData() {
		return service.getAllAttendanceData();
	}
	
	@GetMapping("/get-data-by-id/{facultySttendenceId}")
	public facultyAttendance getAttendanceById(@PathVariable long facultySttendenceId) {
		return service.getAttendanceById(facultySttendenceId);
	}
	
	@PutMapping("/update-data-by-id/{facultySttendenceId}")
	public String updateAttendanceById(@PathVariable long facultySttendenceId, @RequestBody facultyAttendance facultyAttendance) {
		return service.updateAttendanceById(facultySttendenceId,facultyAttendance);
	}
	
	@DeleteMapping("/delete-by-id/{facultySttendenceId}")
	public String deleteFacultyattendence(@PathVariable long facultySttendenceId) {
		return service.deleteFacultyattendence(facultySttendenceId);
	}
	
	
}
