package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.facultyAttendance;

@Repository
public class facultyAttendanceDao {

	@Autowired
	SessionFactory factory;

	public String insertAttendance(facultyAttendance attendance) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(attendance);
		transaction.commit();
		session.close();
		return "Attendance inserted successfully...!";
	}

	public List<facultyAttendance> getAllAttendanceData(facultyAttendance attendance) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(facultyAttendance.class);
		List<facultyAttendance> flist = criteria.list();
		session.close();
		return flist;
	}

	public facultyAttendance getAttendanceById(int id) {
		Session session = factory.openSession();
		facultyAttendance attendance = session.get(facultyAttendance.class, id);
		session.close();
		return attendance;
	}
}
