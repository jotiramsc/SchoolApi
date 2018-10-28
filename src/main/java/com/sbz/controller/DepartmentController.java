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

import com.sbz.entity.Department;
import com.sbz.repository.DepartmentRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping
	public ResponseEntity<List<Department>> getDepartments() {
		return new ResponseEntity<List<Department>>(departmentRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department Department) {
		Department DepartmentTemp = departmentRepository.save(Department);
		Department temp1 = departmentRepository.getOne(DepartmentTemp.getId());
		return new ResponseEntity<Department>(temp1, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Department> updateDepartment(@RequestBody Department Department) {
		departmentRepository.save(Department);
		return new ResponseEntity<Department>(Department, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteDepartment(@PathVariable int id) {
		departmentRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
