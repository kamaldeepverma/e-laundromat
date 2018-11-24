package com.laundrovalley.rest.controller;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.laundrovalley.rest.model.Subscription;
import com.laundrovalley.rest.service.SubscriptionService;

@Controller
public class SubscriptionController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@PostMapping("/subscribe-plan")
	public ModelAndView subscribePlan(@RequestParam("studentId") String studentId,@RequestParam("planId") int planId,@RequestParam("duration") int duration) {
		
		subscriptionService.subscribePlan(studentId,planId,duration);
		ModelAndView mav = new ModelAndView();
		mav.addObject("mode", "MODE_HOME");
		mav.setViewName("home");
		return mav;
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/subscriptions/{id}")
	public Optional<Subscription> getSubscription(@PathVariable int id) {
		return subscriptionService.getSubscription(id);
		}
	
	
	
}
