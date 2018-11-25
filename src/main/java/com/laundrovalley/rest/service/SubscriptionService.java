package com.laundrovalley.rest.service;


import java.sql.Date;
import java.util.Optional;


import com.laundrovalley.rest.model.Subscription;


public interface SubscriptionService {

	public Subscription subscribePlan(String studentId,int planId,int duration);
	public Optional<Subscription> getSubscription(int id);

	public void notifyExpiry();
	public int getDaysLeft(Date expiry,Date today);
	public boolean getStatus(String id);

}
