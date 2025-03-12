package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookDaoImpl;
import com.demo.model.Book;
@Service
public class BookServiceImpl implements IBookService {
  
	@Autowired
	private BookDaoImpl  bookDao;
	@Override
	public void saveBook(Book book)
	{
	    bookDao.saveBookData(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.retrieveAllBooks();
	}

	@Override
	public Book findById(Integer bookId) {
		
		return bookDao.findBookById(bookId);
	}

	@Override
	public void update(Book updateBook) {
		
		bookDao.updateBookById(updateBook);

	}

	@Override
	public void deleteById(Integer bookId) {
		
		bookDao.deleteBookById(bookId);

	}

}
