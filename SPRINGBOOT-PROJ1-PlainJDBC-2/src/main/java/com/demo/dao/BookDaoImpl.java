package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.demo.model.Book;
@Repository
public class BookDaoImpl implements IBookDao
{
    
     
	private Connection connection;
	
	public BookDaoImpl(DataSource dataSource) throws Exception
	{
		this.connection = dataSource.getConnection();
	}
	
	
	@Override
	public void saveBookData(Book book) 
	{
		 try (PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO BOOK_INFO VALUES(?,?,?,?,?)"))
		 {
			  prepareStatement.setInt(1, book.getBookId());
			  prepareStatement.setString(2, book.getBookTitle());
			  prepareStatement.setString(3, book.getAuthorName());
			  prepareStatement.setString(4, book.getGenration());
			  prepareStatement.setDouble(5, book.getBookPrice());
			  
			  //execute query
			  int executeUpdate = prepareStatement.executeUpdate();
			  
			  if(executeUpdate<=0)
			  {
				  throw new IllegalArgumentException("Data can not be stored try again");
			  }
			  else
				  System.out.println("Book data sucessfully stored in database");
		
		 } catch (SQLException e) {
			
			e.printStackTrace();
		} 

	}

	@Override
	public List<Book> retrieveAllBooks()
	{
		List<Book> list = new ArrayList<>();
		try (PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM BOOK_INFO ")) {
			
			ResultSet set = prepareStatement.executeQuery();
			
			while(set.next())
			{
				Book book = Book.builder().bookId(set.getInt(1)).bookTitle(set.getString(2)).authorName(set.getString(3)).genration(set.getString(4)).bookPrice(set.getDouble(5)).build();
				
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Book findBookById(Integer bookId) {
		
		Book book =null;
		try (PreparedStatement prepareStatement = connection.prepareStatement("SELECT *FROM BOOK_INFO WHERE BOOK_ID=?")) {
			
			prepareStatement.setInt(1, bookId);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			if(resultSet.next())
			{
				book = Book.builder().bookId(resultSet.getInt(1)).bookTitle(resultSet.getString(2)).authorName(resultSet.getString(3)).genration(resultSet.getString(4)).bookPrice(resultSet.getDouble(5)).build();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void updateBookById(Book updateBook) 
	{
	     try (PreparedStatement prepareStatement = connection.prepareStatement("UPDATE BOOK_INFO SET BOOK_TITLE=?,AUTHOR_NAME=?,BOOK_GENERATION=?,BOOK_PRICE=? WHERE BOOK_ID=?")) {
			
	    	 prepareStatement.setString(1, updateBook.getBookTitle());
	    	 prepareStatement.setString(2, updateBook.getAuthorName());
	    	 prepareStatement.setString(3, updateBook.getGenration());
	    	 prepareStatement.setDouble(4, updateBook.getBookPrice());
	    	 prepareStatement.setInt(5, updateBook.getBookId());
	    	 
	    	 int update = prepareStatement.executeUpdate();
	    	 
	    	 if(update<=0)
	    	 {
	    		 throw new IllegalArgumentException("Invalid Book Id");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Existing Book data updated in new book data ");
	    	 }
	    	 
		} catch (SQLException e)
	     {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	
     
	}

	@Override
	public void deleteBookById(Integer bookId)
	{
		try (PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM BOOK_INFO WHERE BOOK_ID=? ")) {
			
			prepareStatement.setInt(1, bookId);
			int delete = prepareStatement.executeUpdate();
			
			if(delete<=0)
			{
				throw new IllegalArgumentException("Invalid Book Id");
			}
			else
			{
				System.out.println("Book data deleted based on there id");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
