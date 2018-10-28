package com.sbz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbz.entity.ClassSubMapper;

@Transactional
@Repository
public interface ClassSubMapperRepository extends JpaRepository<ClassSubMapper, Integer> {
	List<ClassSubMapper> deleteByCourseClassId(int sem_id);

	List<ClassSubMapper> getByCourseClassId(int sem_id);
}