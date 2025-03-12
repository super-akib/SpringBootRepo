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
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Product_Manager")
public class Product {
	// product class properties
     
	@SequenceGenerator(name = "myseq" , sequenceName = "proSeq", initialValue = 100,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "myseq")
	@Id
	@Column(name = "product_Id")
	private Integer productId;
	@Column(name = "product_name")
	@NonNull
	private String productName;
	@Column(name = "model_number")
	@NonNull
	private String modelNumber;
	@Column(name = "product_price")
	@NonNull
	private Double productPrice;
	@Column(name = "product_quantity")
	@NonNull
	private Integer productQuntity;
	@Column(name = "manufacturer_name")
	@NonNull
	private String manufacturerName;
	
}
