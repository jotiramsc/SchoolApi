package com.sbz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbz.entity.CourseClass;

@Repository
public interface CourseClassRepository extends JpaRepository<CourseClass, Integer> {

	List<CourseClass> getBycourse_idOrderByIdAsc(int course_id);
	
	@Query("SELECT t FROM CourseClass t where t.abbr=:course_name OR t.name=:course_name") 
	CourseClass getBycourse_abbrOrCourse_name(@Param("course_name") String course_name);
}