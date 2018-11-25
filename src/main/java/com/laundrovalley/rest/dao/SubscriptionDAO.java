package com.laundrovalley.rest.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.laundrovalley.rest.model.Subscription;

public interface SubscriptionDAO {

	public Subscription subscribePlan(Subscription subscription);
	public Optional<Subscription> getSubscription(int id);
	public ArrayList<Subscription> getSubcriptions();
	public int decreaseWashCount(String studentId);
}
