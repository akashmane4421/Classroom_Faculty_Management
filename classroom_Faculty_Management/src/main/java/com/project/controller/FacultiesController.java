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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Faculties;
import com.project.service.FacultiesServise;

@RestController
@RequestMapping("/api/faculties")
public class FacultiesController {
	
	@Autowired
	FacultiesServise service;
	
	@PostMapping("/insert")
	public String createFaculties(@RequestBody Faculties faculties ) {
		return service.createFaculties(faculties);
	}
	
	@GetMapping("/getAllFaculties")
	public List<Faculties> getAllFaculties() {
		return service.getAllFaculties();
	}
	
	@GetMapping("/{id}")
	public Faculties getFacultiesById(@PathVariable int id) {
		System.out.println(service.getFacultiesById(id));
		return service.getFacultiesById(id);
	}

	@PutMapping("/{id}")
	public String updateById(@PathVariable int id,@RequestBody Faculties faculty) {
		return service.updateById(id,faculty);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteFacultiesByid(@PathVariable int id) {
		 service.deleteFacultiesByid(id);
	}
}
