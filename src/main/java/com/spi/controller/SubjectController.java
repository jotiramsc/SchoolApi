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

import com.spi.entity.Subject;
import com.spi.services.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	@GetMapping
	public ResponseEntity<List<Subject>> getSubjects() {
		return new ResponseEntity<List<Subject>>(subjectService.getSubjects(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
		return new ResponseEntity<Subject>(subjectService.addSubject(subject), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
		return new ResponseEntity<Subject>(subjectService.updateSubject(subject), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSubject(@PathVariable int id) {
		subjectService.deleteSubject(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
