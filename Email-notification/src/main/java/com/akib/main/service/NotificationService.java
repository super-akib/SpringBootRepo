package com.akib.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akib.main.comman.INotification;
import com.akib.main.model.User;

@Service
public class NotificationService {
	@Autowired
	private INotification emailNotification;

	public void sendUserNotification(User user, String message, String type) {
		if ("email".equalsIgnoreCase(type)) {
			emailNotification.sendNotification(user, message);
		} else if ("sms".equalsIgnoreCase(type)) {
			emailNotification.sendNotification(user, message);
		} else {
			System.out.println("Notification type not supported: " + type);
		}
	}
}
