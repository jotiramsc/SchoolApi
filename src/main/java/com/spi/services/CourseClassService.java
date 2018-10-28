package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spi.entity.CourseClass;
import com.spi.repository.CourseClassRepository;

@Service
public class CourseClassService {

	@Autowired
	private CourseClassRepository classRepository;

	public List<CourseClass> getCourseClasss() {
		return classRepository.findAll();
	}

	public CourseClass addCourseClass(CourseClass student) {
		return classRepository.save(student);
	}

	public CourseClass updateCourseClass(CourseClass student) {
		classRepository.save(student);
		return classRepository.save(student);
	}

	public List<CourseClass> getClassesByCourseID(@PathVariable int course_id) {
		return classRepository.getBycourse_idOrderByIdAsc(course_id);
	}

	public void deleteCourseClass(@PathVariable int id) {
		classRepository.deleteById(id);

	}

}
