package com.md.book_api.service;

import java.util.List;

import com.md.book_api.model.Book;

public interface BookService {

	//Fetch all books data from database 
	public List<Book> getAllBooks();
	
	//Fetch book data based on Id
	public Book getBookById(Long id);
	
	//Add new book data in database
	public  Book  addBook(Book book);
	
	//Update existing book details
	public Book updateBookDetails(Book book);
	
	//Delete book data based on Id
	public void removeBook(Long id);
}
