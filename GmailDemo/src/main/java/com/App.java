package com;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
       Properties pro =new Properties();
       
       pro.put("mail.smtp.host","smtp.gmail.com");
       pro.put("mail.smtp.port","465");
       pro.put("mail.smtp.ssl.enable","true");
       pro.put("mail.smtp.auth", "true");
       
       Session instance = Session.getInstance(pro, new B());
       
       MimeMessage m=new MimeMessage(instance);
       m.setFrom("lkjl");
       m.addRecipient(Message.RecipientType.TO, new InternetAddress("429shubham@gmail.com"));
       m.setText("khkhjkhk");
       for(int i=0; i<50; i++) {
       Transport.send(m);
       System.out.println("msg send.....");
       }
       
       
       
    }
}
 class B extends Authenticator{
	  @Override
  	protected PasswordAuthentication getPasswordAuthentication() {
  		// TODO Auto-generated method stub
  		return new PasswordAuthentication("mohdakib7385@gmail.com","key");
  	}
 }
