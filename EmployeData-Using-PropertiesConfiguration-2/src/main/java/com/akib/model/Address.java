package com.akib.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("address")
public class Address 
{
   private String street;
   private String city;
   private String zipCode;
}
