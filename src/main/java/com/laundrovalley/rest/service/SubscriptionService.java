package com.laundrovalley.rest.service;


import java.util.Optional;

import com.laundrovalley.rest.model.Subscription;


public interface SubscriptionService {

	public Subscription subscribePlan(String studentId,int planId,int duration);
	public Optional<Subscription> getSubscription(int id);
	public boolean getStatus(String id);
}
