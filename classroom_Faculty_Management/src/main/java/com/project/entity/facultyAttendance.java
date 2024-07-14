package com.project.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class facultyAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long facultySttendenceId;
	private Date date;
	private String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "faculty_id")
	Faculties faculties;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Schedule_Id")
	Schedule schedule;

	public facultyAttendance() {

	}

	public facultyAttendance(Date date, String status, Faculties faculties, Schedule schedule) {
		super();
		this.date = date;
		this.status = status;
		this.faculties = faculties;
		this.schedule = schedule;
	}

	public long getFacultySttendenceId() {
		return facultySttendenceId;
	}

	public void setFacultySttendenceId(long facultySttendenceId) {
		this.facultySttendenceId = facultySttendenceId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Faculties getFaculties() {
		return faculties;
	}

	public void setFaculties(Faculties faculties) {
		this.faculties = faculties;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	
}
