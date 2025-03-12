package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.service.ConfigService;

@SpringBootApplication
public class ConfigurationPrintDetails2Application {

	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = SpringApplication.run(ConfigurationPrintDetails2Application.class, args);
		ConfigService configService = applicationContext.getBean(ConfigService.class);
		
		configService.printDataBaseConfig();
		configService.printApplicationConfig();
	}

}
