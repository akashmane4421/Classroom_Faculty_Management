package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.SubjectDao;
import com.project.entity.Subjects;

@Service
public class SubjectService {

	@Autowired
	SubjectDao dao;

	public String CreateSubjectData(Subjects subjects) {
		return dao.CreateSubjectData(subjects);
	}

	public List<Subjects> getAllSubjects(Subjects subjects) {
		return dao.getAllSubjects(subjects);
	}

	public Subjects getDetailsById(long id) {
		return dao.getDetailsById(id);
	}

	public Subjects updateSubjects(long id, Subjects subjects) {
		return dao.updateSubjects(id,subjects);
	}

	public String deleteSubject(long id) {
		return dao.deleteSubject(id);
	}
}
