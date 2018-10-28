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

import com.spi.entity.Faculty;
import com.spi.repository.FacultyRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
	private FacultyRepository facultyRepository;

	@GetMapping
	public ResponseEntity<List<Faculty>> getFacultys() {
		return new ResponseEntity<List<Faculty>>(facultyRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty Faculty) {
		return new ResponseEntity<Faculty>(facultyRepository.save(Faculty), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty Faculty) {
		facultyRepository.save(Faculty);
		return new ResponseEntity<Faculty>(Faculty, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteFaculty(@PathVariable int id) {
		facultyRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

}
