package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spi.entity.Student;
import com.spi.repository.StudentRepository;

public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return studentRepository.save(student);
	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
