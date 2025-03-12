package com.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book 
{
	private Integer bookId;
	private String bookTitle;
	private String authorName;
	private String genration ;
	private Double bookPrice;
}
