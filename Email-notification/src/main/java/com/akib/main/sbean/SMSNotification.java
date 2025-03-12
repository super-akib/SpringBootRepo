package com.akib.main.sbean;

import org.springframework.stereotype.Component;

import com.akib.main.comman.INotification;
import com.akib.main.model.User;
@Component
public class SMSNotification implements INotification {

	@Override
    public void sendNotification(User user, String message) 
	{
        System.out.println("SMS sent to " + user.getPhoneNumber() + ": " + message);
    }

}
