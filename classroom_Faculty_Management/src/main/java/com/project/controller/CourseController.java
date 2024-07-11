package com.project.controller;

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
	    private CourseService service;

	    @GetMapping
	    public List<Course> getAllCourses(Course course) {
	        return service.getAllCourses(course);
	    }

	    @GetMapping("/{id}")
	    public Course getCourseById(@PathVariable Long id) {
	        return service.getCourseById(id);
	    }

	    @PostMapping("/insert")
	    public Course createCourse(@RequestBody Course course) {
	        service.createCourse(course);
	        return course;
	    }

	    @PutMapping("/{id}")
	    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
	        Course course = service.getCourseById(id);// DB se
	        if (course != null) {
	            course.setName(courseDetails.getName()); // hamara data set
	            service.updateCourse(course);
	        }
	        return course;
	    }

	    @DeleteMapping("/{id}")
	    public String deleteCourse(@PathVariable Long id) {
	      return   service.deleteCourse(id);
	    }
}
