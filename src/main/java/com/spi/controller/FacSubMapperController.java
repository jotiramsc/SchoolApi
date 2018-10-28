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

import com.spi.entity.FacSubMapper;
import com.spi.services.FacSubMapperService;

@RestController
@RequestMapping("/api/facsubmappers")
public class FacSubMapperController {
	@Autowired
	private FacSubMapperService facSubMapperService;

	@GetMapping("/{sem_id}")
	public ResponseEntity<List<FacSubMapper>> getFacSubMappersBySem(@PathVariable int sem_id) {
		return new ResponseEntity<List<FacSubMapper>>(facSubMapperService.getFacSubMappersBySem(sem_id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<FacSubMapper>> getFacSubMappers() {
		return new ResponseEntity<List<FacSubMapper>>(facSubMapperService.getFacSubMappers(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<List<FacSubMapper>> addFacSubMappers(@RequestBody List<FacSubMapper> subjectMappers) {
		return new ResponseEntity<List<FacSubMapper>>(facSubMapperService.addFacSubMappers(subjectMappers),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<FacSubMapper> updateFacSubMapper(@RequestBody FacSubMapper facSubMapper) {
		return new ResponseEntity<FacSubMapper>(facSubMapperService.updateFacSubMapper(facSubMapper), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFacSubMapper(@PathVariable int id) {
		facSubMapperService.deleteFacSubMapper(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
