package com.laundrovalley.rest.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laundrovalley.rest.model.Plan;
import com.laundrovalley.rest.service.PlanService;

@RestController
public class PlanController {
	@Autowired
	PlanService planServiceObject;
	@RequestMapping(method=RequestMethod.GET, value="/plans")	
	public ArrayList<Plan> getPlans() {
		//ArrayList<Plan> plans=new ArrayList<>();
		return planServiceObject.getPlans();
		}
	
	@RequestMapping(method=RequestMethod.GET,value="/plans/{id}")
	public Optional<Plan> getPlan(@PathVariable int id) {
		
		return planServiceObject.getPlan(id);
		}
	
	@RequestMapping(value="/plans", method=RequestMethod.POST)
	public Plan addPlan(@Valid @RequestBody Plan tempPlan){
		System.out.println(tempPlan);
		//Plan tempPlan=new Plan(id, amount, type);
		return planServiceObject.addPlan(tempPlan);
		
	}
}
