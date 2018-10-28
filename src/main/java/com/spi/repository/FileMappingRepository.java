package com.spi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spi.entity.FileMapping;

@Repository
public interface FileMappingRepository extends JpaRepository<FileMapping, Integer> {
	
	FileMapping findByFileName(String file_name);
}
