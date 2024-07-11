package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.Classroomdao;
import com.project.entity.Classroom;

@Service
public class ClassroomService {
	@Autowired
	Classroomdao dao;

	public String insertdata(Classroom classroom) {
		return dao.insertdata(classroom);
	}

	public List<Classroom> getAllClassrooms(Classroom classroom) {
		return dao.getAllClassrooms(classroom);
	}

	public Classroom getClassroomById(long id) {
		
		return dao.getClassroomById(id);
	}

	public String createClassroom(Classroom classroom) {
		return dao.createClassroom(classroom);
	}

	public void updateClassroom(Classroom classroom) {
		  dao.updateClassroom(classroom);
	}

	public void deleteClassroom(long id) {

		dao.deleteClassroom(id);
	}

}
