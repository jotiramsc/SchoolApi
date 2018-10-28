package com.spi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spi.entity.Faculty;
import com.spi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}