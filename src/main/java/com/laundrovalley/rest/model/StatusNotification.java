package com.laundrovalley.rest.model;

public class StatusNotification extends Notification{

	public void constructMessage(String recipientEmail,String recipientName, String attr) {
		 this.recipientEmail = recipientEmail;
		 this.subject = "Wash Status Notification";
		 if(attr.equalsIgnoreCase("completed"))
			 attr = attr + " and will be delivered as per scheduled time.";
		 this.text = " Hello , "+recipientName+"\n Your Wash Status is changed to "+attr;
	 		
		}
}
