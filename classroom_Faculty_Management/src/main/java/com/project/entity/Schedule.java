package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long scheduleId;
	
	@Column(name = "classroom_id")
	long classrooomId;
	
	@Column(name = "day_of_week")
	String dayOfWeek;
	
	@Column(name ="start_time")
	String startTime;
	
	@Column(name = "end_time")
	String endTime;
	
	@Column(name = "subject_id")
	long subjectId;

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(long classrooomId, String dayOfWeek, String startTime, String endTime, long subjectId) {
		super();
		this.classrooomId = classrooomId;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.subjectId = subjectId;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long id) {
		this.scheduleId = id;
	}

	public long getClassrooomId() {
		return classrooomId;
	}

	public void setClassrooomId(long classrooomId) {
		this.classrooomId = classrooomId;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	
	
	
	
}
