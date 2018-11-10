package com.laundrovalley.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundrovalley.rest.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>{

}
