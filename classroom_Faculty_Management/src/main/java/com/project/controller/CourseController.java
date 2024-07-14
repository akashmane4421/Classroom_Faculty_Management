package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Course;
import com.project.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/insert")
	public Course createCourse(@RequestBody Course course) {
		courseService.createCourse(course);
		return course;
	}

	@GetMapping("/get-all-courses")
	public ArrayList<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@GetMapping("/get-by-Id/{courseId}")
	public List<Course> getCourseById(@PathVariable Long courseId) {
		return courseService.getCourseById(courseId);
	}

	@PutMapping("/update-by-id/{courseId}")
	public String updateCourse(@PathVariable Long courseId, @RequestBody Course courseDetails) {
		return courseService.updateCourse(courseDetails, courseId);
	}

	@DeleteMapping("/delete-by-id/{courseId}")
	public String deleteCourse(@PathVariable Long courseId) {
		return courseService.deleteCourse(courseId);
	}
}
