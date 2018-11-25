package com.laundrovalley.rest.model;

public abstract class Notification {

	protected String recipientEmail;
	protected String subject;
	protected String text;
	
	
	public String getRecipientEmail() {
		return recipientEmail;
	}


	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public abstract void constructMessage(String recipient,String subject,String attribute);
	
}
