package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.facultyAttendanceDao;
import com.project.entity.facultyAttendance;

@Service
public class facultyAttendanceService {
	
	@Autowired
	facultyAttendanceDao dao;

	public String insertAttendance(facultyAttendance attendance) {
		return dao.insertAttendance(attendance);
	}

	public List<facultyAttendance> getAllAttendanceData(facultyAttendance attendance) {
		return dao.getAllAttendanceData(attendance);
	}

	public facultyAttendance getAttendanceById(int id) {
		return dao.getAttendanceById(id);
	}

}
