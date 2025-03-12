package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.service.MailService;

@SpringBootApplication
public class JavaMailApi1Application {

	public static void main(String[] args)throws Exception {
		ConfigurableApplicationContext  ctx = SpringApplication.run(JavaMailApi1Application.class, args);
		
		       MailService mailService = ctx.getBean(MailService.class);
		       
		       
		       String mail = mailService.sendMail("sujitmaharana6370@gmail.com");
		       
		       System.out.println(mail);
		
	}

}
