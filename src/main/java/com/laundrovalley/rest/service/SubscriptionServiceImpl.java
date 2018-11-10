package com.laundrovalley.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.SubscriptionDAO;
import com.laundrovalley.rest.model.Subscription;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	SubscriptionDAO subscriptionDAO;
		
	@Override
	public Subscription subscribePlan(Subscription subscription) {
		
		return subscriptionDAO.subscribePlan(subscription);
	}

	@Override
	public Optional<Subscription> getSubscription(int id) {
		
		return subscriptionDAO.getSubscription(id);
	}

	
}
