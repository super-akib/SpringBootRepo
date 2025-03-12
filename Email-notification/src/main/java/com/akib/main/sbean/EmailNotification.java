package com.akib.main.sbean;

import org.springframework.stereotype.Component;

import com.akib.main.comman.INotification;
import com.akib.main.model.User;

@Component
public class EmailNotification implements INotification {

	@Override
	public void sendNotification(User user, String message) {
		System.out.println("Email sent to " + user.getEmailId() + ": " + message);
	}
}
