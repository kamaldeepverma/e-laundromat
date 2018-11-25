package com.laundrovalley.rest.model;

public class NotificationFactory {

	public static Notification getNotificationInstance(String type) {
		
		if(type.equalsIgnoreCase("expiry"))
			return new ExpiryNotification();
		else if(type.equalsIgnoreCase("status"))
			return new StatusNotification();
		return null;
	}
}
