package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long classroomId;
	String classroomName;
	
	
	public Classroom() {
		super();
	}


	public Classroom( String classroomName) {
		super();
		this.classroomName = classroomName;
	}


	public long getClassroomId() {
		return classroomId;
	}


	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}


	public String getClassroomName() {
		return classroomName;
	}


	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	
	
	
}
