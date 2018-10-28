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

import com.spi.entity.ClassSubMapper;
import com.spi.repository.ClassSubMapperRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/classsubmappers")
public class ClassSubMapperController {
	@Autowired
	private ClassSubMapperRepository mapperRepository;

	@GetMapping("/{sem_id}")
	public ResponseEntity<List<ClassSubMapper>> getClassSubMappersByClass(@PathVariable int sem_id) {
		return new ResponseEntity<List<ClassSubMapper>>(mapperRepository.getByCourseClassId(sem_id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ClassSubMapper>> getClassSubMappers() {
		return new ResponseEntity<List<ClassSubMapper>>(mapperRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<List<ClassSubMapper>> addClassSubMappers(@RequestBody List<ClassSubMapper> subjectMappers) {

		if (subjectMappers != null && subjectMappers.size() > 0 && subjectMappers.get(0) != null) {
			mapperRepository.deleteByCourseClassId(subjectMappers.get(0).getCourseClass().getId());
		}
		return new ResponseEntity<List<ClassSubMapper>>(mapperRepository.saveAll(subjectMappers), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ClassSubMapper> updateClassSubMapper(@RequestBody ClassSubMapper ClassSubMapper) {
		mapperRepository.save(ClassSubMapper);
		return new ResponseEntity<ClassSubMapper>(ClassSubMapper, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteClassSubMapper(@PathVariable int id) {
		mapperRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
