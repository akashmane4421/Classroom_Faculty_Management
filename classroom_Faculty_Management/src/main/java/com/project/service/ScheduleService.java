package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Masseges;
import com.project.dao.ScheduleDao;
import com.project.entity.Schedule;

@Service
public class ScheduleService {

	@Autowired
	ScheduleDao dao;

	public String CreateSchedule(Schedule schedule) {
		if (dao.CreateSchedule(schedule)) {
			return Masseges.insertData();
		} else {
			return Masseges.notInsertData();
		}
	}

	public ArrayList<Schedule> getAllSchedules(Schedule schedule) {
		return dao.getAllSchedules(schedule);
	}

	public List<Schedule> getScheduleById(long scheduleId) {
		if (dao.getScheduleById(scheduleId) != null) {
			return dao.getScheduleById(scheduleId);
		} else {
			Masseges.notFoundData();
		}
		return null;
	}

	public String updateSchedules(Schedule schedule, long scheduleId) {
		if (dao.updateSchedules(schedule, scheduleId)) {
			return Masseges.updateData();
		} else {
			return Masseges.notUpdateData();
		}
	}

	public String deleteSchedule(long scheduleId) {
		if (dao.deleteSchedule(scheduleId)) {
			return Masseges.deleteData();
		} else {
			return Masseges.notDeleteData();
		}
	}

}
