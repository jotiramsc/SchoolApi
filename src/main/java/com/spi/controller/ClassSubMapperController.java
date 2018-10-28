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

import com.spi.entity.ClassSubMapper;
import com.spi.services.ClassSubMapperService;

@RestController
@RequestMapping("/api/classsubmappers")
public class ClassSubMapperController {

	@Autowired
	private ClassSubMapperService classService;

	@GetMapping("/{sem_id}")
	public ResponseEntity<List<ClassSubMapper>> getClassSubMappersByClass(@PathVariable int sem_id) {
		return new ResponseEntity<List<ClassSubMapper>>(classService.getClassSubMappersByClass(sem_id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ClassSubMapper>> getClassSubMappers() {
		return new ResponseEntity<List<ClassSubMapper>>(classService.getClassSubMappers(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<List<ClassSubMapper>> addClassSubMappers(@RequestBody List<ClassSubMapper> subjectMappers) {

		return new ResponseEntity<List<ClassSubMapper>>(classService.addClassSubMappers(subjectMappers), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ClassSubMapper> updateClassSubMapper(@RequestBody ClassSubMapper classSubMapper) {
		return new ResponseEntity<ClassSubMapper>(classService.updateClassSubMapper(classSubMapper), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClassSubMapper(@PathVariable int id) {
		classService.deleteClassSubMapper(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
