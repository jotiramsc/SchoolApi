package com.spi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spi.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}