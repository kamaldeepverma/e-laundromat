package com.laundrovalley.rest.service;


import java.sql.Date;
import java.util.Optional;

import javax.mail.MessagingException;

import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.model.Subscription;


public interface SubscriptionService {

	public Subscription subscribePlan(String studentId,int planId,int duration);
	public Optional<Subscription> getSubscription(int id);

	public void notifyExpiry();
	public void sendEmail(Student student,Subscription subscription) throws MessagingException ;
	public int getDaysLeft(Date expiry,Date today);

	public boolean getStatus(String id);

}
