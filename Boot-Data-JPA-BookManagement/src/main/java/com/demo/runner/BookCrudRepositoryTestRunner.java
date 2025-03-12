package com.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Book;
import com.demo.service.IBookService;
@Component
public class BookCrudRepositoryTestRunner implements CommandLineRunner {
   
	@Autowired
	private IBookService  bookService;
	@Override
	public void run(String... args) throws Exception
	{
		//create book object 
		
	//	Book book  = Book.builder().bookTitle("python Programming").authorName(" Jhon Mike").bookPrice(650.0).publishedYear(2022).build();
		
		//invoke save method of service class
		//bookService.saveBook(book);
		
//		Book bookTitle = bookService.findByBookTitle("Java programming");
//		System.out.println(bookTitle);
		
//		Book book2 = bookService.findByBookIdAndbookTitle(1002, "python Programming");
//		System.out.println(book2);
		  bookService.findByBookId(1000);
		  
		// System.out.println(findByBookId.getBookId());
		
	}

}
