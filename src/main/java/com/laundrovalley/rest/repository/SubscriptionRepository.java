package com.laundrovalley.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laundrovalley.rest.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>{

	@Query("from Subscription where studentId=?1 and status=true")
	public Subscription getSubscription(String studentId);
}
