package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbz.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	
}