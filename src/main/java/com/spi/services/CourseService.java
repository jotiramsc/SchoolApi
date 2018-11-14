package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spi.config.AppUtil;
import com.spi.entity.Course;
import com.spi.entity.CourseClass;
import com.spi.entity.Semister;
import com.spi.repository.CourseClassRepository;
import com.spi.repository.CourseRepository;
import com.spi.repository.SemisterRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private SemisterRepository semisterRepository;

	@Autowired
	private CourseClassRepository classRepository;

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	public Course addCourse(Course course) {
		return courseRepository.save(addUpdateSemisters(course));
	}

	public Course updateCourse(Course course) {

		Course prevCourse = courseRepository.getOne(course.getId());
		if (null == prevCourse.getType() || !prevCourse.getType().equalsIgnoreCase(course.getType()))
			course = this.addUpdateSemisters(course);
		return courseRepository.save(course);
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);

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
				String class_name = course.getName() + " " + AppUtil.IntegerToRoman(class_count);
				String class_abbr = course.getAbbr() + " " + AppUtil.IntegerToRoman(class_count);
				c = new CourseClass(class_name, class_abbr, class_name, course);
				classRepository.save(c);
				class_count++;
			} else if (i % 2 == 0) {
				String class_name = course.getName() + " " + AppUtil.IntegerToRoman(class_count);
				String class_abbr = course.getAbbr() + " " + AppUtil.IntegerToRoman(class_count);
				c = new CourseClass(class_name, class_abbr, class_name, course);
				classRepository.save(c);
				class_count++;
			}
			String roman = AppUtil.IntegerToRoman(i + 1);
			Semister sem = new Semister(nameString + " " + roman, abbrString + " " + roman,
					course.getName() + " " + nameString + " " + roman, duration, c);

			semisterRepository.save(sem);
		}

		return course;

	}

}
