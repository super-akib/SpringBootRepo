package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.model.PlayerInfo;

@SpringBootApplication
public class BootIocProj5PlayerInfoProfile1Application {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(BootIocProj5PlayerInfoProfile1Application.class, args);
		
		PlayerInfo playerInfo = applicationContext.getBean(PlayerInfo.class);
		
		System.out.println(playerInfo);
	}

}
