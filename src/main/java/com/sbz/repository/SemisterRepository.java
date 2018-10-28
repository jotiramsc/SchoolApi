package com.sbz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbz.entity.Semister;

@Repository
@Transactional
public interface SemisterRepository extends JpaRepository<Semister, Integer> {
	
	List<Semister> getBycourseClass_idOrderByIdAsc(int course_id);
	List<Semister> findAllByOrderByCourseClassAscIdAsc();
	List<Semister> deleteBycourseClass_id(int course_id);
}