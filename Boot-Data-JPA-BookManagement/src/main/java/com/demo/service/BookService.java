package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Book;
import com.demo.repository.IBookRepository;
@Service("bookService")
public class BookService implements IBookService
{
    @Autowired
    private IBookRepository    bookRepository;
    
	@Override
	public void saveBook(Book book)
	{
	     if(book != null)
	     {
	    	 bookRepository.save(book);
	    	 System.out.println("Book data sucessfully inserted in table.");
	     }
	     else
	     {
	    	 throw new IllegalArgumentException("In case Book object is null");
	     }

	}

	@Override
	public Book findByBookId(Integer bookId) 
	{
		//get book object by id
		Book referenceById = bookRepository.getReferenceById(bookId);
		  // System.out.println(referenceById.getAuthorName());
		//Book referenceById2 = bookRepository.getReferenceById(bookId);
		
		 System.out.println(referenceById);
		// System.out.println(referenceById==referenceById2);
		return null;//bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book id try again.")) ;
	}

	@Override
	public Book findByBookTitle(String bookTitle) {
		//get book object by title
		return bookRepository.findByBookTitle(bookTitle);
	}

	@Override
	public Book findByPublishedYear(Integer year) {
		//get book object by published year
		return bookRepository.findByPublishedYear(year);
	}

	@Override
	public Book findByBookIdAndbookTitle(Integer bookId, String bookTitle) {
		
		return  bookRepository.findByBookIdAndBookTitle(bookId, bookTitle);
	}

	

}
