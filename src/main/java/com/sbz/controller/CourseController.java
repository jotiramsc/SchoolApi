package com.sbz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

import com.sbz.config.SBZUtil;
import com.sbz.entity.Course;
import com.sbz.entity.CourseClass;
import com.sbz.entity.Semister;
import com.sbz.repository.CourseClassRepository;
import com.sbz.repository.CourseRepository;
import com.sbz.repository.SemisterRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private SemisterRepository semisterRepository;
	
	@Autowired
	private CourseClassRepository classRepository;

	@GetMapping
	public ResponseEntity<List<Course>> getCourses() {
		return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		return new ResponseEntity<Course>(courseRepository.save(addUpdateSemisters(course)), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {

		Course prevCourse = courseRepository.getOne(course.getId());
		if (null == prevCourse.getType() || !prevCourse.getType().equalsIgnoreCase(course.getType()))
			course = this.addUpdateSemisters(course);

		courseRepository.save(course);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteCourse(@PathVariable int id) {
		courseRepository.deleteById(id);
		return new ResponseEntity(null, HttpStatus.OK);
	}

	@Transactional
	private Course addUpdateSemisters(Course course) {
		int objCount = 0;
		String nameString = "Year";
		String abbrString = "Year";
		int duration = 12;

//		if (course.getId() > 0) {
//			semisterRepository.deleteByCourse_id(course.getId());
//		}
		// course.setSemisters(new HashSet<Semister>());

		if (course.getType().equalsIgnoreCase("annual")) {
			objCount = course.getDuration();
			nameString = "Year";
			abbrString = "Year";
			duration = 12;
		} else {
			objCount = course.getDuration() * 2;
			nameString = "Semister";
			abbrString = "SEM";
			duration = 6;
		}

		courseRepository.save(course);
		CourseClass c = null;
		int class_count = 1;
		for (int i = 0; i < objCount; i++) {

			if (course.getType().equalsIgnoreCase("annual")) {
				String class_name = course.getName() + " " + SBZUtil.IntegerToRoman(class_count);
				String class_abbr = course.getAbbr() + " " + SBZUtil.IntegerToRoman(class_count);
				c = new CourseClass(class_name, class_abbr, class_name, course);
				classRepository.save(c);
				class_count++;
			}else if(i%2==0)
			{
				String class_name = course.getName() + " " + SBZUtil.IntegerToRoman(class_count);
				String class_abbr = course.getAbbr() + " " + SBZUtil.IntegerToRoman(class_count);
				c = new CourseClass(class_name, class_abbr, class_name, course);
				classRepository.save(c);
				class_count++;
			}
			 String roman = SBZUtil.IntegerToRoman(i + 1);
			 Semister sem = new Semister(nameString + " " + roman, abbrString + " " +
			 roman,
			 course.getName() + " " + nameString + " " + roman, duration,c);

			semisterRepository.save(sem);
		}

		return course;

	}

}
