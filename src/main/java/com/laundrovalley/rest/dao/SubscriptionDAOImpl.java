package com.laundrovalley.rest.dao;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Subscription;
import com.laundrovalley.rest.repository.SubscriptionRepository;

@Transactional
@Service
public class SubscriptionDAOImpl implements SubscriptionDAO{
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Override
	public Subscription subscribePlan(Subscription subscription) {
		System.out.println(subscription);
		return subscriptionRepository.save(subscription);
	}

	@Override
	public Optional<Subscription> getSubscription(int id) {
		
			
			return subscriptionRepository.findById(id);
		}

	@Override
	public ArrayList<Subscription> getSubcriptions() {
		
		return (ArrayList<Subscription>) subscriptionRepository.findAll();
	}

	@Override
	public int decreaseWashCount(String studentId) {
		subscriptionRepository.decreaseWashCount(studentId);
		
		return 0;
	}
	
}

	
	


