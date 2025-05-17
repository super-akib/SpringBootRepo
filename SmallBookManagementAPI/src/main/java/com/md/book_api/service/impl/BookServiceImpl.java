package com.md.book_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.book_api.model.Book;
import com.md.book_api.repository.BookRepository;
import com.md.book_api.service.BookService;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> getAllBooks() {
		
		return repository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		
		return  repository.findById(id).orElseThrow(()-> new RuntimeException("No such Book found Exception."));
	}

	@Override
	public Book addBook(Book book) {
	
		return repository.save(book);
	}

	@Override
	public Book updateBookDetails(Book book) {
		
		//check whether  book is present or not
		Book oldBook = repository
		   .findById(book.getId())
		       .orElseThrow(()->new RuntimeException("No such book found Exception."));
		//Set new details to old book object 
		oldBook.setTitle(book.getTitle());
		oldBook.setAuthor(book.getAuthor());
		oldBook.setIsBn(book.getIsBn());
		oldBook.setPublishedDate(book.getPublishedDate());
		
		return repository.save(oldBook);
	}

	@Override
	public void removeBook(Long id) {
		repository.deleteById(id);
	}

}
