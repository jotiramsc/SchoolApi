package com.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spi.config.AppUtil;
import com.spi.entity.Course;
import com.spi.entity.CourseClass;
import com.spi.entity.Semister;
import com.spi.repository.CourseClassRepository;
import com.spi.repository.CourseRepository;
import com.spi.repository.SemisterRepository;
import com.spi.services.CourseService;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;


	@GetMapping
	public ResponseEntity<List<Course>> getCourses() {
		return new ResponseEntity<List<Course>>(courseService.getCourses(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		return new ResponseEntity<Course>(courseService.addCourse(course), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		return new ResponseEntity<Course>(courseService.updateCourse(course), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

	

}
