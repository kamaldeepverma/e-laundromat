package com.laundrovalley.rest.controller;


import java.util.ArrayList;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.laundrovalley.rest.model.Plan;
import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.service.PlanService;
import com.laundrovalley.rest.service.SubscriptionService;

@Controller
public class PlanController {
	@Autowired
	PlanService planServiceObject;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@RequestMapping("plans")	
	public ModelAndView listPlans(@SessionAttribute("stud") Student stud) {
	
		ArrayList<Plan> plans = planServiceObject.getPlans();
		System.out.println(stud.getId());
		ModelAndView mav = new ModelAndView();
		mav.addObject("plans",plans);
		mav.addObject("mode", "MODE_LIST_PLANS");
		mav.setViewName("home");
		return mav;
	
	}
	
	@RequestMapping("/plans/{id}")
	public ModelAndView getPlan(@SessionAttribute("stud") Student stud,@PathVariable("id") int id) {
		System.out.println(id+"47mv");
		Plan plan = planServiceObject.getPlan(id);
		boolean status = subscriptionService.getStatus(stud.getId());
		
		ModelAndView mav = new ModelAndView();
		
		if(plan != null)
		{
			mav.addObject("mode", "MODE_SUBSCRIBE_PLAN");
			mav.addObject("plan",plan);
			mav.addObject("subscribed",!status);
			mav.addObject("stud",stud);
			mav.setViewName("home");
		}
		else
		{
			mav.addObject("mode", "MODE_HOME");
			mav.setViewName("home");	
		}
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/plans", method=RequestMethod.POST)
	public Plan addPlan(@Valid @RequestBody Plan tempPlan){
		System.out.println(tempPlan);
		//Plan tempPlan=new Plan(id, amount, type);
		return planServiceObject.addPlan(tempPlan);
		
	}
}
