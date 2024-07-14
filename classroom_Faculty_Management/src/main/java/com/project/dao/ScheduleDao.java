package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Masseges;
import com.project.entity.Schedule;

@Repository
public class ScheduleDao {

	@Autowired
	SessionFactory factory;

	public boolean CreateSchedule(Schedule schedule) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(schedule);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public ArrayList<Schedule> getAllSchedules(Schedule schedule) {
		ArrayList<Schedule> schedules = null;
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Schedule.class);
			schedules = (ArrayList<Schedule>) criteria.list();
			session.close();
			return schedules;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public List<Schedule> getScheduleById(long id) {
		List<Schedule> schedules = null;
		try {
			Session session = factory.openSession();
			schedules = (List<Schedule>) session.get(Schedule.class, id);
			session.close();
			return schedules;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return null;
	}

	public boolean updateSchedules(Schedule scheduleDetails, long scheduleId) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Schedule schedule = session.get(Schedule.class, scheduleId);
			if (schedule != null) {
				schedule.setClassrooomId(scheduleDetails.getClassrooomId());
				schedule.setDayOfWeek(scheduleDetails.getDayOfWeek());
				schedule.setStartTime(scheduleDetails.getStartTime());
				schedule.setEndTime(scheduleDetails.getEndTime());
				schedule.setSubjectId(scheduleDetails.getSubjectId());
				session.update(schedule);
			}
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

	public boolean deleteSchedule(long id) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Schedule schedule = session.load(Schedule.class, id);
			session.delete(schedule);
			transaction.commit();
			session.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			Masseges.error();
		}
		return false;
	}

}
