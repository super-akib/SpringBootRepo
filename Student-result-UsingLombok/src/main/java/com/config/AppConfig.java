package com.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sbean")
public class AppConfig 
{
   @Bean(name ="scan")
   public Scanner getScanner()
   {
	  return new Scanner(System.in);
   }
}
