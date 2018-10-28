package com.spi.controller;

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

import com.spi.entity.Subject;
import com.spi.repository.SubjectRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	@Autowired
	private SubjectRepository subjectRepository;

	@GetMapping
	public ResponseEntity<List<Subject>> getSubjects() {
		return new ResponseEntity<List<Subject>>(subjectRepository.findAll(), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Subject> addSubject(@RequestBody Subject Subject) {
		return new ResponseEntity<Subject>(subjectRepository.save(Subject), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject Subject) {
		subjectRepository.save(Subject);
		return new ResponseEntity<Subject>(Subject, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteSubject(@PathVariable int id) {
		subjectRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
