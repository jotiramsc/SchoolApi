package com.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spi.entity.Book;
import com.spi.repository.BookRepository;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		return new ResponseEntity<List<Book>>(bookRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookRepository.save(book), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		bookRepository.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteBook(@PathVariable int id) {
		bookRepository.deleteById(id);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

}
