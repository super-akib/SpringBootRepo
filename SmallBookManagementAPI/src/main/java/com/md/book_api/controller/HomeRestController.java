package com.md.book_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.md.book_api.model.Book;
import com.md.book_api.service.BookService;

@RestController
@RequestMapping("/book-api")
public class HomeRestController {
  
	@Autowired
	private BookService service;
	
	//fetch all books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> displayAllBooks(){
		return new ResponseEntity<List<Book>>(service.getAllBooks(), HttpStatus.OK);
	}
	
	//Add book 
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		return new ResponseEntity<Book>(service.addBook(book), HttpStatus.CREATED);
	}
	
	//Update book details 
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> modifyBookDetails(@RequestBody Book book, @PathVariable Long id)
	{
		//set path variable Id to book object field 
		book.setId(id);
		
		return new ResponseEntity<>(service.updateBookDetails(book),HttpStatus.OK);
	}
	
	//Fetch book by Id
	@GetMapping("/show/{id}")
	public ResponseEntity<Book> showBook(@PathVariable  Long id)
	{
		return new ResponseEntity<Book>(service.getBookById(id), HttpStatus.OK);
	}
	
	
	//Delete book based on Id 
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String>  deleteBook(@PathVariable Long id)
	{
		return new ResponseEntity<>("No."+id+" Book is deleted.",HttpStatus.OK);
	}
	
	
}
