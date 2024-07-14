package com.project.controller;

import java.util.ArrayList;
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
	public ArrayList<Subjects> getAllSubjects() {
		return service.getAllSubjects();
		
	}
	
	@GetMapping("/by-id/{id}")
	public List<Subjects> getDetailsById(@PathVariable long subjectId) {
		return service.getDetailsById(subjectId);
	}
	
	@PutMapping("/update-by-id/{id}")
	public String updateSubjects(@PathVariable long subjectId,@RequestBody Subjects subjects) {
		return service.updateSubjects(subjectId,subjects);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public String deleteSubject(@PathVariable long subjectId ) {
		return service.deleteSubject(subjectId);
	}
}
