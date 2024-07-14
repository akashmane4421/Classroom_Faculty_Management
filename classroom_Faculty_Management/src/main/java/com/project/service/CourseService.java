package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Masseges;
import com.project.dao.CourseDao;
import com.project.entity.Course;

@Service
public class CourseService {

	@Autowired
	CourseDao dao;

	public String createCourse(Course course) {
		if (dao.createCourse(course)) {
			return Masseges.insertData();
		} else {
			return Masseges.notInsertData();
		}

	}

	public ArrayList<Course> getAllCourses() {
		return dao.getAllCourses();
	}

	public List<Course> getCourseById(Long courseId) {
		if (dao.getCourseById(courseId) != null) {
			return dao.getCourseById(courseId);
		} else {
			Masseges.notFoundData();
		}
		return null;
	}

	public String deleteCourse(Long courseId) {
		if (dao.deleteCourse(courseId)) {
			return Masseges.deleteData();
		} else {
			return Masseges.notDeleteData();
		}
	}

	public String updateCourse(Course courseDetails, Long courseId) {
		if (dao.updateCourse(courseDetails, courseId)) {
			return Masseges.updateData();
		} else {
			return Masseges.notUpdateData();
		}
	}

}
