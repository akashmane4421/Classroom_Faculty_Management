package com.project.controller;

import java.util.ArrayList;
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
	public ArrayList<Schedule> getAllSchedules(Schedule schedule) {
		return servise.getAllSchedules(schedule);
	}
	
	@GetMapping("/get-by-id/{scheduleId}")
	public List<Schedule> getScheduleById(@PathVariable long scheduleId ) {
		return servise.getScheduleById(scheduleId);
	}
	
	@PutMapping("/update-by-id/{scheduleId}")
	public String updateSchedules(@PathVariable long scheduleId,@RequestBody Schedule scheduleDetails) {
		return servise.updateSchedules(scheduleDetails,scheduleId);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public String  deleteSchedule(@PathVariable long scheduleId) {
		return servise.deleteSchedule(scheduleId);
	}
}
