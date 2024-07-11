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

import com.project.entity.Classroom;
import com.project.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	private ClassroomService service;

	@PostMapping("/insert")
	public String insertdata(@RequestBody Classroom classroom) {
		return service.insertdata(classroom);
	}

	@GetMapping("/get-all-data")
	public List<Classroom> getAllClassrooms(Classroom classroom) {
		return service.getAllClassrooms(classroom);
	}

	@GetMapping("/{id}")
	public Classroom getClassroomById(@PathVariable int id) {
		return service.getClassroomById(id);
	}

	@PostMapping("{id}")
	public String createClassroom(Classroom classroom) {

		return service.createClassroom(classroom);

	}

	@PutMapping("/{id}")
	public Classroom updateClassroom(@PathVariable long id, @RequestBody Classroom classroomDetails) {
		Classroom classroom = service.getClassroomById(id);
		if (classroom != null) {
			classroom.setName(classroomDetails.getName());
			service.updateClassroom(classroom);
		}
		return classroom;
	}

	@DeleteMapping("/{id}")
	public String deleteClassroom(@PathVariable long id) {
		if (id == 0) {
			return "no id found for deleting";
		} else {
			service.deleteClassroom(id);
			return "data deleted...";
		}

	}
}
