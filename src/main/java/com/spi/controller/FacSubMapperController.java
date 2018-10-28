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

import com.spi.entity.FacSubMapper;
import com.spi.repository.FacSubMapperRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/facsubmappers")
public class FacSubMapperController {
	@Autowired
	private FacSubMapperRepository mapperRepository;

	@GetMapping("/{sem_id}")
	public ResponseEntity<List<FacSubMapper>> getFacSubMappersBySem(@PathVariable int sem_id) {		
		return new ResponseEntity<List<FacSubMapper>>(mapperRepository.getByFaculty_id(sem_id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<FacSubMapper>> getFacSubMappers() {
		return new ResponseEntity<List<FacSubMapper>>(mapperRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<List<FacSubMapper>> addFacSubMappers(@RequestBody List<FacSubMapper> subjectMappers) {
	
		if(subjectMappers!= null && subjectMappers.size()>0 && subjectMappers.get(0) != null)
		{
			mapperRepository.deleteByFaculty_id(subjectMappers.get(0).getFaculty().getId());
		}
		return new ResponseEntity<List<FacSubMapper>>(mapperRepository.saveAll(subjectMappers), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<FacSubMapper> updateFacSubMapper(@RequestBody FacSubMapper FacSubMapper) {
		mapperRepository.save(FacSubMapper);
		return new ResponseEntity<FacSubMapper>(FacSubMapper, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteFacSubMapper(@PathVariable int id) {
		mapperRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
