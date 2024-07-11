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
	int id;
	
	@Column(unique = true)
	String email;
	
	@Column(name = "department_id", nullable = false)
    private long departmentId;
	
	String name;
	
	
	public Faculties() {
		super();
		}
	
	public Faculties(int id, String email, long departmentId, String name) {
		this.id = id;
		this.email = email;
		this.departmentId = departmentId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDepartment_id() {
		return departmentId;
	}

	public void setDepartment_id(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Faculties [id=" + id + ", email=" + email + ", department_id=" +" departmentId" + ", name=" + name + "]";
	}

	
	
}
