package com.sbz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.sbz.entity.CourseClass;
import com.sbz.entity.Semister;
import com.sbz.repository.CourseClassRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/classes")
public class CourseClassController {

	@Autowired
	private CourseClassRepository classRepository;

	@GetMapping
	public ResponseEntity<List<CourseClass>> getCourseClasss() {
		return new ResponseEntity<List<CourseClass>>(classRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CourseClass> addCourseClass(@RequestBody CourseClass student) {
		return new ResponseEntity<CourseClass>(classRepository.save(student), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<CourseClass> updateCourseClass(@RequestBody CourseClass student) {
		classRepository.save(student);
		return new ResponseEntity<CourseClass>(student, HttpStatus.OK);
	}
	@GetMapping("/{course_id}")
	public ResponseEntity<List<CourseClass>> getClassesByCourseID(@PathVariable int course_id) {
		return new ResponseEntity<List<CourseClass>>(classRepository.getBycourse_idOrderByIdAsc(course_id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteCourseClass(@PathVariable int id) {
		classRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

}
