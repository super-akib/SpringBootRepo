package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer>
{
	  //find book record based on title
      Book findByBookTitle(String bookTitle);
      
      //find book record based on published Year
      Book findByPublishedYear(Integer year);
      
      //find book record based on id and title
      Book findByBookIdAndBookTitle(Integer bookId, String bookTitle);
      
}
