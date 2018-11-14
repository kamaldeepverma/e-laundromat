package com.laundrovalley.rest.controller;


import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.laundrovalley.rest.model.Plan;
import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.service.PlanService;

@Controller
public class PlanController {
	@Autowired
	PlanService planServiceObject;
	
	@RequestMapping("plans")	
	public String getPlans(@SessionAttribute("stud") Student stud,Model model,HttpServletRequest request) {
		
		
		ArrayList<Plan> plans = planServiceObject.getPlans();
		
		request.setAttribute("plans",plans);
		request.setAttribute("mode", "MODE_SUBSCRIBE_PLAN");
		return "home";
	
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
