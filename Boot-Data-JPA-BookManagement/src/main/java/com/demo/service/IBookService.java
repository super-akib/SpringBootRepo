package com.demo.service;

import com.demo.entity.Book;

public interface IBookService
{
	//Save book object in database table
    void saveBook(Book book);
    
    //Find book record by id
    Book findByBookId(Integer bookId);
    
    //Find book record by title
    Book  findByBookTitle(String bookTitle);
    
    // find book record by published year
    Book findByPublishedYear(Integer year);
    
    //find book record by id and title
    Book findByBookIdAndbookTitle(Integer bookId,String bookTitle);
    
    
}
