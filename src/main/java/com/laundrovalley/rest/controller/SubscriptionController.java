package com.laundrovalley.rest.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Subscription;
import com.laundrovalley.rest.service.SubscriptionService;

@RestController
public class SubscriptionController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@RequestMapping(method=RequestMethod.POST,value="/subscribe")
	public GeneratedIdResponse subscribePlan(@Valid @RequestBody Subscription subscription) {
		
			
		 Subscription temp=subscriptionService.subscribePlan(subscription);
		 int id=temp.getId();
		 GeneratedIdResponse generatedId=new GeneratedIdResponse(String.valueOf(id)); 
		 return generatedId;
		}
	
	@RequestMapping(method=RequestMethod.GET,value="/subscriptions/{id}")
	public Optional<Subscription> getSubscription(@PathVariable int id) {
		return subscriptionService.getSubscription(id);
		}
	
}
