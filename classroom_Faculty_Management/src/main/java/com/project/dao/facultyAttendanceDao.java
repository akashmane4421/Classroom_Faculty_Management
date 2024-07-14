package com.project.dao;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Masseges;
import com.project.entity.facultyAttendance;

@Repository
public class facultyAttendanceDao {

	@Autowired
	SessionFactory factory;

	public boolean insertAttendance(facultyAttendance attendance) {
		try {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(attendance);
		transaction.commit();
		session.close();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public ArrayList<facultyAttendance> getAllAttendanceData() {
		ArrayList<facultyAttendance> facultyAttendances = null;
		try {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(facultyAttendance.class);
	    facultyAttendances = (ArrayList<facultyAttendance>) criteria.list();
		session.close();
		return facultyAttendances;
		}catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public facultyAttendance getAttendanceById(long facultySttendenceId) {
		try {
		Session session = factory.openSession();
		facultyAttendance attendance = session.get(facultyAttendance.class, facultySttendenceId);
		session.close();
		return attendance;
		}catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public boolean updateAttendanceById(long facultySttendenceId, facultyAttendance facultyAttendance) {
		try {
			Session session=factory.openSession();
			Transaction transaction = session.beginTransaction();
			facultyAttendance faculty = session.get(facultyAttendance.class, facultySttendenceId);
			if(faculty!=null) {
				faculty.setDate(facultyAttendance.getDate());
				faculty.setFaculties(facultyAttendance.getFaculties());
				faculty.setSchedule(facultyAttendance.getSchedule());
				faculty.setStatus(facultyAttendance.getStatus());
				session.update(faculty);
			}
			transaction.commit();
			session.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public boolean deleteFacultyattendence(long facultySttendenceId) {
		try {
			Session session=factory.openSession();
			Transaction transaction=session.beginTransaction();
			facultyAttendance facultyAttendance=session.load(facultyAttendance.class,facultySttendenceId);
			session.delete(facultyAttendance);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}
}
