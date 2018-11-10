package com.laundrovalley.rest.service;


import java.util.Optional;

import com.laundrovalley.rest.model.Subscription;


public interface SubscriptionService {

	public Subscription subscribePlan(Subscription subscription);
	public Optional<Subscription> getSubscription(int id);
}
