package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subjectId;
	@Column(name = "course_id")
	long courseId;
	
	String subjectName;

	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subjects(long courseId, String subjectName) {
		super();
		this.courseId = courseId;
		this.subjectName = subjectName;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
}
