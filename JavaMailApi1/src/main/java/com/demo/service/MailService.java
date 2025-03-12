package com.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service("mailService")
public class MailService  
{
   @Autowired
	private JavaMailSender  mailSender;
   
   @Value("${spring.mail.username}")
   private String fromMaill;
   
   
   public String sendMail(String toMail) throws MessagingException
   {
	   MimeMessage    message  =  mailSender.createMimeMessage();
	   MimeMessageHelper   helper  = new MimeMessageHelper(message,true);
	   
	   helper.setFrom(fromMaill);
	   helper.setCc(toMail);
	   helper.setSubject("java mail testing");
	   helper.setText("Welcome to Spring Boot Course");
	   helper.setSentDate(new Date());
	   mailSender.send(message);
	   return "Mail sent";
   }
}
