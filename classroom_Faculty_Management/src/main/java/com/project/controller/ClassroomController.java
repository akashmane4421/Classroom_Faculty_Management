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

import com.project.entity.Classroom;
import com.project.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	@PostMapping("/insert")
	public String insertClassroomData(@RequestBody Classroom classroom) {
		return classroomService.insertdata(classroom);
	}

	@GetMapping("/get-all-data")
	public ArrayList<Classroom> getAllClassrooms() {
		return classroomService.getAllClassrooms();
	}

	@GetMapping("/{classroomId}")
	public Classroom getClassroomById(@PathVariable int classroomId) {
		return classroomService.getClassroomById(classroomId);
	}

	@PutMapping("/{classroomId}")
	public String updateClassroom(@PathVariable("classroomId") long classroomId, @RequestBody Classroom classroomDetails) {
		return classroomService.updateClassroom(classroomDetails,classroomId);
		
	}

	@DeleteMapping("/{classroomId}")
	public String deleteClassroom(@PathVariable long classroomId) {
		return classroomService.deleteClassroom(classroomId);

	}
}
