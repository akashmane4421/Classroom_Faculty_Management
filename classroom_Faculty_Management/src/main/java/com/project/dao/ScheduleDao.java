package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Schedule;

@Repository
public class ScheduleDao {

	@Autowired
	SessionFactory factory;

	public String CreateSchedule(Schedule schedule) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(schedule);
		tx.commit();
		session.close();
		return "Data insert Successfully";
	}

	public List<Schedule> getAllSchedules(Schedule schedule) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Schedule.class);
		List<Schedule> slist = criteria.list();
		session.close();
		return slist;
	}

	public Schedule getScheduleById(long id) {
		Session session = factory.openSession();
		Schedule schedule = session.get(Schedule.class, id);
		session.close();
		return schedule;
	}

	public Schedule updateSchedules(Schedule schedule) {

		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(schedule);
		transaction.commit();
		session.close();
		return schedule;
	}

	public String deleteSchedule(long id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Schedule schedule=session.load(Schedule.class, id);
		session.delete(schedule);
		transaction.commit();
		session.close();
		return "Data Delete Sccessfully";
	}

}
