package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbz.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}