package com.project.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Masseges;
import com.project.dao.facultyAttendanceDao;
import com.project.entity.facultyAttendance;

@Service
public class facultyAttendanceService {
	
	@Autowired
	facultyAttendanceDao dao;

	public String insertAttendance(facultyAttendance attendance) {
		if(dao.insertAttendance(attendance)) {
			return Masseges.insertData();
		}else {
			return Masseges.notInsertData();
		}
	}

	public ArrayList<facultyAttendance> getAllAttendanceData() {
		return dao.getAllAttendanceData();
	}

	public facultyAttendance getAttendanceById(long facultySttendenceId) {
		return dao.getAttendanceById(facultySttendenceId);
	}

	public String updateAttendanceById(long facultySttendenceId, facultyAttendance facultyAttendance) {
		if(dao.updateAttendanceById(facultySttendenceId,facultyAttendance)) {
			return Masseges.updateData();
		}else {
			return Masseges.notUpdateData();
		}
	}

	public String deleteFacultyattendence(long facultySttendenceId) {
		if (dao.deleteFacultyattendence(facultySttendenceId)) {
			return Masseges.deleteData();
		} else {
			return Masseges.notDeleteData();
		}
	}

}
