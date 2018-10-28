package com.spi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spi.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}