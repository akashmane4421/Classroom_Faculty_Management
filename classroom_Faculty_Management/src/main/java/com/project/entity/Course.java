package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;

	@Column(nullable = false)
	private String courseName;

	public Course() {
		super();
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
