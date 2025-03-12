package com.akib.main.comman;

import com.akib.main.model.User;

public interface INotification {
	void sendNotification(User user, String message);
}
