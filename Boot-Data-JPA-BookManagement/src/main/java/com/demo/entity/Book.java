package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor

@Builder
@RequiredArgsConstructor
@Table(name = "Book_Store")
public class Book {
	public Book() {
		System.out.println("Book.Book()");
	}
	@SequenceGenerator(name = "genrator", sequenceName = "seq2", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genrator")
	@Id
	@Column(name = "book_id")
	private Integer bookId;
	@Column(name = "book_title")
	@NonNull
	private String bookTitle;
	@Column(name = "author_name")
	@NonNull
	private String authorName;
	@Column(name = "book_price")
	@NonNull
	private Double bookPrice;
	
	@Column(name = "published_year")
	@NonNull
	private Integer publishedYear;
}
