package com.md.book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.md.book_api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	
}
