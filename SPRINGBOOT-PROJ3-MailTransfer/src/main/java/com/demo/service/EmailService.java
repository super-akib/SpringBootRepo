package com.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.demo.entity.UserData;

import jakarta.mail.internet.MimeMessage;
@Component("emailService")
public class EmailService 
{  
	@Autowired
    private JavaMailSender  sender;
	
	@Value("${spring.mail.username}")
	   private String fromMaill;
	
	public void sendMail(UserData userData)
	{
		try 
		{
			MimeMessage    message  =  sender.createMimeMessage();
			   MimeMessageHelper   helper  = new MimeMessageHelper(message,true);
			   
			   helper.setFrom(fromMaill);
			   helper.setCc(userData.getEmailId());
			   helper.setSubject("Registeration of Spring Boot");
			   helper.setText("Hello , "+userData.getUserName()+" your Successfully registered.");
			   helper.setSentDate(new Date());
			   sender.send(message);
			
			   System.out.println("Registration mail sended check email box");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
