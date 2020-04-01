package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    //private final EntityManager entityManager;
	private final BookRepository bookRepository;

    @Transactional
    public BookEntity createBook(String title, String isbn, String author) {
        BookEntity book = new BookEntity();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setAuthor(author);

        return bookRepository.saveAndFlush(book);
    }
    
    public List<BookEntity> getBooks() {
    	//return entityManager.createQuery("FROM BookEntity", BookEntity.class).getResultList();\
    	return bookRepository.findAll();
    }
    
    public List<BookEntity> getBook(int id) {
    	//return entityManager.createQuery("FROM BookEntity WHERE id="+id, BookEntity.class).getResultList();
    	List<BookEntity> res = new ArrayList<BookEntity>();
    	res.add(bookRepository.findById(id).get());
    	return res;
    }
    
    public List<BookEntity> getBookByTitle(String title) {
    	//return entityManager.createQuery("FROM BookEntity WHERE title="+title, BookEntity.class).getResultList();
    	return bookRepository.findAllByTitle(title);
    }
    
    public List<BookEntity> getBookByISBN(String isbn) {
    	//return entityManager.createQuery("FROM BookEntity WHERE isbn="+isbn, BookEntity.class).getResultList();
    	return bookRepository.findAllByIsbn(isbn);
    }
    
    public List<BookEntity> getBookByAuthor(String author) {
    	//return entityManager.createQuery("FROM BookEntity WHERE author="+author, BookEntity.class).getResultList();
    	return bookRepository.findAllByAuthor(author);
    }

}