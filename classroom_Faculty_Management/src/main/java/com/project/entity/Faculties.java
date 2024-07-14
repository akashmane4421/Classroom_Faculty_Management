package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faculties {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long facultyId;
	
	@Column(unique = true)
	String email;
	
	@Column(name = "department_id", nullable = false)
    private long departmentId;
	
	String FacultyName;
	
	
	public Faculties() {
		super();
		}


	public Faculties(String email, long departmentId, String facultyName) {
		super();
		this.email = email;
		this.departmentId = departmentId;
		FacultyName = facultyName;
	}


	public long getFacultyId() {
		return facultyId;
	}


	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}


	public String getFacultyName() {
		return FacultyName;
	}


	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}
	
	

	
	
}
