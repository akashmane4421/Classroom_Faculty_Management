package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Subjects;
import com.project.service.SubjectService;

@RestController
@RequestMapping("/api/Subjects")
public class SubjectController {
	@Autowired
	SubjectService service;
	
	@PostMapping("/insert-Subject")
	public String CreateSubjectData(@RequestBody Subjects subjects) {
		return service.CreateSubjectData(subjects);
	}

	@GetMapping("/get-all-data")
	public List<Subjects> getAllSubjects(Subjects subjects) {
		System.out.println(subjects);
		return service.getAllSubjects(subjects);
		
	}
	
	@GetMapping("/by-id/{id}")
	public Subjects getDetailsById(@PathVariable long id) {
		return service.getDetailsById(id);
	}
	
	@PutMapping("/update-by-id/{id}")
	public Subjects updateSubjects(@PathVariable long id,@RequestBody Subjects subjects) {
		return service.updateSubjects(id,subjects);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public String deleteSubject(@PathVariable long id ) {
		return service.deleteSubject(id);
	}
}
