package com.laundrovalley.rest.service;



import com.laundrovalley.rest.model.Notification;


public interface EmailService {

	public void sendEmail(Notification notification);
	
}
