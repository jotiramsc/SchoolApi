package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spi.entity.Faculty;
import com.spi.repository.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;

	public List<Faculty> getFaculties() {
		return facultyRepository.findAll();
	}

	public Faculty addFaculty(Faculty Faculty) {
		return facultyRepository.save(Faculty);
	}

	public Faculty updateFaculty(Faculty Faculty) {
		return facultyRepository.save(Faculty);

	}

	public void deleteFaculty(int id) {
		facultyRepository.deleteById(id);
	}

}
