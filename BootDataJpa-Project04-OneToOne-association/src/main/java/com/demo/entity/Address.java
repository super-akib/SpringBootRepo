package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@Setter
@Getter
@Table(name="user_address_info")
public class Address
{  	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @NonNull
   @Column(name = "Street_name")
   private String streetName;
   @NonNull
   @Column(name = "city_name")
   private String cityName;
   @NonNull
   @Column(name="state_name")
   private String stateName;
   @NonNull
   @Column(name="country_name")
   private String countryName;
   
   @OneToOne(mappedBy = "address")
   private User user;

@Override
public String toString() {
	return "Address [ streetName=" + streetName + ", cityName=" + cityName +", stateName"+stateName+ ", countryName="
			+ countryName + "]";
}
   
   
}
