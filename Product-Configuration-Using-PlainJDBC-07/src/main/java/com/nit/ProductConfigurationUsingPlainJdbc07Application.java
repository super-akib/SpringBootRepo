package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.service.ConfigService;

@SpringBootApplication
public class ProductConfigurationUsingPlainJdbc07Application {

	public static void main(String[] args) 
	{
		ApplicationContext applicationContext = SpringApplication.run(ProductConfigurationUsingPlainJdbc07Application.class, args);
        
		ConfigService configService = applicationContext.getBean(ConfigService.class);
		
		
		configService.printDatabaseConfig();
		configService.printProductConfig();
		
		//store data into products table in database using plain JDBC
		configService.storeProductConfigInDatabase();
		
		
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
