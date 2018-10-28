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

import com.spi.entity.Department;
import com.spi.services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;

	@GetMapping
	public ResponseEntity<List<Department>> getDepartments() {
		return new ResponseEntity<List<Department>>(deptService.getDepartments(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return new ResponseEntity<Department>(deptService.createDepartment(department), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		return new ResponseEntity<Department>(deptService.updateDepartment(department), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable int id) {
		deptService.deleteDepartment(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
