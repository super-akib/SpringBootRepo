package com.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "product_info")
public class Product
{
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Id
   @Column(name = "product_id")
   private Integer productId;
   @NonNull
   @Column(name = "product_name")
   private String  productName;
   @NonNull
   @Column(name = "product_brand")
   private String  brandName;
   @NonNull
   @Column(name = "product_made_In")
   private String  madeIn;
   @NonNull
   @Column(name = "product_price")
   private Double  price;
}
