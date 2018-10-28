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

import com.spi.entity.Faculty;
import com.spi.services.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@GetMapping
	public ResponseEntity<List<Faculty>> getFaculties() {
		return new ResponseEntity<List<Faculty>>(facultyService.getFaculties(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
		return new ResponseEntity<Faculty>(facultyService.addFaculty(faculty), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
		return new ResponseEntity<Faculty>(facultyService.updateFaculty(faculty), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFaculty(@PathVariable int id) {
		facultyService.deleteFaculty(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

}
