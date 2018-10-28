package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spi.entity.Department;
import com.spi.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	public Department createDepartment(Department Department) {
		Department DepartmentTemp = departmentRepository.save(Department);
		return departmentRepository.getOne(DepartmentTemp.getId());
	}

	public Department updateDepartment(Department Department) {
		return departmentRepository.save(Department);
	}

	public void deleteDepartment(int id) {
		departmentRepository.deleteById(id);
	}
}
