package com.laundrovalley.rest.service;

import java.util.Date;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.SubscriptionDAO;
import com.laundrovalley.rest.model.Plan;
import com.laundrovalley.rest.model.Subscription;
import com.laundrovalley.rest.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	SubscriptionDAO subscriptionDAO;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	PlanService planService;

	@Autowired
	SubscriptionRepository subscriptionRepository;
		
	@Override
	public Subscription subscribePlan(String studentId,int planId,int duration) {
		
		
		
		Plan plan = planService.getPlan(planId);
		Calendar cal = Calendar.getInstance();
		Subscription subscription = new Subscription();
		
		
		
		cal.add(Calendar.MONTH, duration);
		Date expiryDate = cal.getTime();
		
		java.sql.Date sqlExpiryDate = new java.sql.Date(expiryDate.getTime());
		subscription.setExpiry(sqlExpiryDate);
		subscription.setWashes(duration*plan.getWashes());
		subscription.setPlanId(planId);
		subscription.setStudentId(studentId);
		subscription.setStatus(true);
		subscription.setAmount(duration*plan.getAmount());
		
		subscriptionDAO.subscribePlan(subscription);
		
		return subscription;
	}

	@Override
	public Optional<Subscription> getSubscription(int id) {
		
		return subscriptionDAO.getSubscription(id);
	}

	@Override
	public boolean getStatus(String id) {
		
		Subscription subscription = subscriptionRepository.getSubscription(id);
		if(subscription!=null)
			return true;
		else
			return false;
	}

	
}
