package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Masseges;
import com.project.dao.Classroomdao;
import com.project.entity.Classroom;

@Service
public class ClassroomService {
	@Autowired
	Classroomdao classroomDao;

	public String insertdata(Classroom classroom) {
		if (classroomDao.insertdata(classroom)) {
			return Masseges.insertData();
		} else {
			return Masseges.notInsertData();
		}
	}

	public ArrayList<Classroom> getAllClassrooms() {
		return classroomDao.getAllClassrooms();
	}

	public Classroom getClassroomById(long id) {
		if (classroomDao.getClassroomById(id) != null) {
			return classroomDao.getClassroomById(id);
		} else {
			Masseges.notFoundData();
		}
		return null;
	}

	public String updateClassroom(Classroom classroomDetails, long classroomId) {
		if (classroomDao.updateClassroom(classroomDetails, classroomId)) {
			return Masseges.updateData();
		} else {
			return Masseges.notUpdateData();
		}
	}

	public String deleteClassroom(long classroomId) {
		if (classroomDao.deleteClassroom(classroomId)) {
			return Masseges.deleteData();
		} else {
			return Masseges.notDeleteData();
		}

	}

}
