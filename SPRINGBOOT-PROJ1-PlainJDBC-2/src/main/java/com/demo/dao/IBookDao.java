package com.demo.dao;

import java.util.List;

import com.demo.model.Book;

public interface IBookDao 
{
	
	void saveBookData(Book book);
	
	List<Book> retrieveAllBooks();
	
	Book findBookById(Integer bookId);
	
	void updateBookById(Book updateBook);
	
	void deleteBookById(Integer bookId);
}
