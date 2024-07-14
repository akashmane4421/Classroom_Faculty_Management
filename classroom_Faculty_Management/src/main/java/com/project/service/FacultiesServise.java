package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Masseges;
import com.project.dao.FacultiesDao;
import com.project.entity.Faculties;

@Service
public class FacultiesServise {

	@Autowired
	FacultiesDao dao;
	
	public String createFaculties(Faculties faculties) {
		if (dao.createFaculties(faculties)) {
			return Masseges.insertData();
		} else {
			return Masseges.notInsertData();
		}
	}

	public ArrayList<Faculties> getAllFaculties() {
		return dao.getAllFaculties();
	}

	public List<Faculties> getFacultiesById(long facultyId) {
		if ( dao.getFacultiesById(facultyId)!=null) {
			return dao.getFacultiesById(facultyId);
		} else {
			Masseges.notFoundData();
		}
		return null;
	}

	public String updateById(long facultyId, Faculties faculty) {
		if (dao.updateById(facultyId, faculty)) {
			return Masseges.updateData();
		} else {
			return Masseges.notUpdateData();
		}
	}

	public String deleteFacultiesByid(long facultyId) {
		if (dao.deleteFacultiesByid(facultyId)) {
			return Masseges.deleteData();
		} else {
			return Masseges.notDeleteData();
		}
		
	}

}
