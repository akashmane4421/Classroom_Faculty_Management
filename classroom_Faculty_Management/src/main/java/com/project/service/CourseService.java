package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CourseDao;
import com.project.entity.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseDao dao;

	public Course createCourse(Course course) {
		return dao.createCourse(course);
	}

	public List<Course> getAllCourses(Course course) {

		return dao.getAllCourses(course);
	}

	public Course getCourseById(Long id) {

		return dao.getCourseById(id);
	}
	
	public Course updateCourse(Course course) {
		return dao.updateCourse(course);
	}

	public String deleteCourse(Long id) {
		return dao.deleteCourse(id);
	}
	
}
