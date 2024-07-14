package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Masseges;
import com.project.dao.SubjectDao;
import com.project.entity.Subjects;

@Service
public class SubjectService {

	@Autowired
	SubjectDao dao;

	public String CreateSubjectData(Subjects subjects) {
		if (dao.CreateSubjectData(subjects)) {
			return Masseges.insertData();
		} else {
			return Masseges.notInsertData();
		}
	}

	public ArrayList<Subjects> getAllSubjects() {
		return dao.getAllSubjects();
	}

	public List<Subjects> getDetailsById(long subjectId) {
		if (dao.getDetailsById(subjectId) != null) {
			return dao.getDetailsById(subjectId);
		} else {
			Masseges.notFoundData();
		}
		return null;
	}

	public String updateSubjects(long subjectId, Subjects subjects) {
		if (dao.updateSubjects(subjectId, subjects)) {
			return Masseges.updateData();
		} else {
			return Masseges.notUpdateData();
		}
	}

	public String deleteSubject(long subjectId) {
		if (dao.deleteSubject(subjectId)) {
			return Masseges.deleteData();
		} else {
			return Masseges.notDeleteData();
		}
	}
}
