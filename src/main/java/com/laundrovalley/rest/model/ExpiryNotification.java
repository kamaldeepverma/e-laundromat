package com.laundrovalley.rest.model;

public class ExpiryNotification extends Notification {

	
	public void constructMessage(String recipientEmail,String recipientName, String attr) {
	 this.recipientEmail = recipientEmail;
	 this.subject = "Expiration Notification";
	 this.text = " Hello ,"+recipientName+"\n Your subscription is expiring on "+attr;
 		
	}

}
