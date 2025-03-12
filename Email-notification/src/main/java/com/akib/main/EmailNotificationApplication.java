package com.akib.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akib.main.model.User;
import com.akib.main.service.NotificationService;

@SpringBootApplication
public class EmailNotificationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(EmailNotificationApplication.class, args);
	
		 NotificationService service = applicationContext.getBean(NotificationService.class); 
		User user = new User();
        user.setUserId(111021);
        user.setUserName("John Doe");
        user.setEmailId("john.doe@example.com");
        user.setPhoneNumber(1234567890);
        
        
        service.sendUserNotification(user, "Hell via Email", "email");
        service.sendUserNotification(user, "Hello via SMS!", "sms");
	}

}
