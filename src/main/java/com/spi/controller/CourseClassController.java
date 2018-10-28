package com.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spi.entity.CourseClass;
import com.spi.services.CourseClassService;

@RestController
@RequestMapping("/api/classes")
public class CourseClassController {

	@Autowired
	private CourseClassService classService;

	@GetMapping
	public ResponseEntity<List<CourseClass>> getCourseClasss() {
		return new ResponseEntity<List<CourseClass>>(classService.getCourseClasss(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CourseClass> addCourseClass(@RequestBody CourseClass courseClass) {
		return new ResponseEntity<CourseClass>(classService.addCourseClass(courseClass), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<CourseClass> updateCourseClass(@RequestBody CourseClass courseClass) {
		return new ResponseEntity<CourseClass>(classService.updateCourseClass(courseClass), HttpStatus.OK);
	}

	@GetMapping("/{course_id}")
	public ResponseEntity<List<CourseClass>> getClassesByCourseID(@PathVariable int course_id) {
		return new ResponseEntity<List<CourseClass>>(classService.getClassesByCourseID(course_id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCourseClass(@PathVariable int id) {
		classService.deleteCourseClass(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

}
