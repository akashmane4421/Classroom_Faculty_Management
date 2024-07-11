package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ScheduleDao;
import com.project.entity.Schedule;

@Service
public class ScheduleService {

	@Autowired
	ScheduleDao dao;
	
	public String CreateSchedule(Schedule schedule) {
		return dao.CreateSchedule(schedule);
	}

	public List<Schedule> getAllSchedules(Schedule schedule) {
		return dao.getAllSchedules(schedule);
	}

	public Schedule getScheduleById(long id) {
		return dao.getScheduleById(id);
	}

	public Schedule updateSchedules(Schedule schedule) {
      return dao.updateSchedules(schedule);		
	}

	public String deleteSchedule(long id) {
		return dao.deleteSchedule(id);
	}

}
