package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	List<BookEntity> findAll();
	
	List<BookEntity> findAllByTitle(String title);
	
	List<BookEntity> findAllByAuthor(String Author);
	
	List<BookEntity> findAllByIsbn(String Isbn);
}