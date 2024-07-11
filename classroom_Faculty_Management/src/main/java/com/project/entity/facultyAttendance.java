package com.project.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class facultyAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
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

	public facultyAttendance(int id, Date date, String status, Faculties faculties, Schedule schedule) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.faculties = faculties;
		this.schedule = schedule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "facultyAttendance [id=" + id + ", date=" + date + ", status=" + status + ", faculties=" + faculties
				+ ", schedule=" + schedule + "]";
	}

	
	

}
