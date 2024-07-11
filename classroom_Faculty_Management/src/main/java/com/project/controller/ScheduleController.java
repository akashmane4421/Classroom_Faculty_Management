package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Schedule;
import com.project.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleService servise;
	
	@PostMapping("insert")
	public String CreateSchedule(@RequestBody Schedule schedule) {
		return servise.CreateSchedule(schedule);
	}

	@GetMapping("/all-Schedules")
	public List<Schedule> getAllSchedules(Schedule schedule) {
		return servise.getAllSchedules(schedule);
	}
	
	@GetMapping("/get-by-id/{id}")
	public Schedule getScheduleById(@PathVariable long id ) {
		return servise.getScheduleById(id);
	}
	
	@PutMapping("/update-by-id/{id}")
	public Schedule updateSchedules(@PathVariable long id,@RequestBody Schedule scheduleDetails) {
		Schedule schedule=servise.getScheduleById(id);
		if(schedule!=null) {
			schedule.setClassrooomId(scheduleDetails.getClassrooomId());
			schedule.setDayOfWeek(scheduleDetails.getDayOfWeek());
			schedule.setStartTime(scheduleDetails.getStartTime());
			schedule.setEndTime(scheduleDetails.getEndTime());
			schedule.setSubjectId(scheduleDetails.getSubjectId());
			servise.updateSchedules(schedule);
		}
		return schedule;
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public String  deleteSchedule(@PathVariable long id) {
		return servise.deleteSchedule(id);
	}
}
