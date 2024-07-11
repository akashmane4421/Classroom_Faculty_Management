package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.FacultiesDao;
import com.project.entity.Faculties;

@Service
public class FacultiesServise {

	@Autowired
	FacultiesDao dao;
	
	public String createFaculties(Faculties faculties) {
		return dao.createFaculties(faculties);
	}

	public List<Faculties> getAllFaculties() {
		return dao.getAllFaculties();
	}

	public Faculties getFacultiesById(int id) {
		return dao.getFacultiesById(id);
	}

	public String updateById(int id, Faculties faculty) {
		 return dao.updateById(id, faculty);
	}

	public void deleteFacultiesByid(int id) {
		dao.deleteFacultiesByid(id);
	}

}
