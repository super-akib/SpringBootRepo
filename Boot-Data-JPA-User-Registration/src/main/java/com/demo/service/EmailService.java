package com.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.demo.entity.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service("mailService")
public class EmailService
{
	@Autowired
    private JavaMailSender  mailSender;
    
	@Value("${spring.mail.username}")
	private String fromMail;
	
     public String sendMail(User user, String message) throws MessagingException
     {
    	MimeMessage   mimeMessage = mailSender.createMimeMessage();
    	MimeMessageHelper  helper = new MimeMessageHelper(mimeMessage,true);
    	
    	
    	//set mail properties and send mail to user
    	helper.setFrom(fromMail);
    	helper.setCc(user.getEmailId());
    	helper.setSubject("Registration Status");
    	helper.setText(user.getFirstName()+" "+user.getLastName()+" "+message);
    	helper.setSentDate(new Date());
    	mailSender.send(mimeMessage);
    	
    	 return "You got the email check out in your mail box";
     }
}
