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

import com.sbz.entity.Semister;
import com.sbz.repository.SemisterRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/semisters")
public class SemisterController {
	@Autowired
	private SemisterRepository semisterRepository;

	@GetMapping
	public ResponseEntity<List<Semister>> getSemisters() {
		return new ResponseEntity<List<Semister>>(semisterRepository.findAllByOrderByCourseClassAscIdAsc(), HttpStatus.OK);
	}
	@GetMapping("/{course_id}")
	public ResponseEntity<List<Semister>> getSemistersByCourseID(@PathVariable int course_id) {
		return new ResponseEntity<List<Semister>>(semisterRepository.getBycourseClass_idOrderByIdAsc(course_id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Semister> addSemister(@RequestBody Semister Semister) {		
		return new ResponseEntity<Semister>(semisterRepository.save(Semister), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Semister> updateSemister(@RequestBody Semister Semister) {
		semisterRepository.save(Semister);
		return new ResponseEntity<Semister>(Semister, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteSemister(@PathVariable int id) {
		semisterRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
