package com.demo.service;

import java.util.List;

import com.demo.model.Book;

public interface IBookService 
{
   void saveBook(Book book);
   List<Book>  getAllBooks();
   Book  findById(Integer bookId);
   void update(Book updateBook);
   void deleteById(Integer bookId);
   
   
}
