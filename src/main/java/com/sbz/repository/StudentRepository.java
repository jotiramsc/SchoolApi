package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbz.entity.Faculty;
import com.sbz.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}