package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbz.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}