package com.laundrovalley.rest.service;

import java.sql.Date;


public interface EmailService {

	public void SendEmail(String email,Date expiry);
	
}
