package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spi.entity.Subject;
import com.spi.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}

	public Subject addSubject(Subject Subject) {
		return subjectRepository.save(Subject);
	}

	public Subject updateSubject(Subject Subject) {
		subjectRepository.save(Subject);
		return subjectRepository.save(Subject);
	}

	public void deleteSubject(int id) {
		subjectRepository.deleteById(id);
	}

}
