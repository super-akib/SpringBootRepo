package com.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.Book;
import com.demo.service.BookServiceImpl;
@Component
public class BookTestRunner implements CommandLineRunner {
    
	@Autowired
	private BookServiceImpl  bookService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		//Book book1 = Book.builder().bookId(100).bookTitle("Java Programming").authorName("Xyz").genration("First Edition").bookPrice(450.0).build();

		//bookService.saveBook(book1);
		
		
//		List<Book> allBooks = bookService.getAllBooks();
//		
//		for (Book book : allBooks) {
//			
//			System.out.println(book);
//			
	
//		//get the by id
//		Book book2 = bookService.findById(100);
//         System.out.println(book2);
		
		//Update 
		Book book3 = Book.builder().bookId(100).bookTitle("Python Programming").authorName("Xyz").genration("First Edition").bookPrice(350.0).build();
	   bookService.update(book3);
	}

}
