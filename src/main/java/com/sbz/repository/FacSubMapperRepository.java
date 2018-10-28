package com.sbz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbz.entity.FacSubMapper;

@Transactional
@Repository
public interface FacSubMapperRepository extends JpaRepository<FacSubMapper, Integer> {
	List<FacSubMapper> deleteByFaculty_id(int sem_id);

	List<FacSubMapper> getByFaculty_id(int sem_id);
}