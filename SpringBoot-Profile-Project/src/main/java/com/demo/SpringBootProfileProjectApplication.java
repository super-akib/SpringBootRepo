package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.config.DBCon;

@SpringBootApplication
public class SpringBootProfileProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootProfileProjectApplication.class, args);
		DBCon bean = run.getBean(DBCon.class);
		bean.DBConn();
	}

}
