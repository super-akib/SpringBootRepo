package com.akib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.akib.service.ConfigService;

@SpringBootApplication
public class UserConfigurationUsingPlainJdbc8Application {

	public static void main(String[] args)
	{
		ApplicationContext applicationContext = SpringApplication.run(UserConfigurationUsingPlainJdbc8Application.class, args);
		
		ConfigService configService = applicationContext.getBean(ConfigService.class);
		
		//invoke the print database configuration method
		configService.printDatabaseConfig();
		//invoke the user configuration print method
		configService.printUserConfig();
		//invoke the data store method 
		configService.storeUserConfigInDatabase();
		
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
