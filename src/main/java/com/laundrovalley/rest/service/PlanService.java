package com.laundrovalley.rest.service;

import java.util.ArrayList;
import java.util.Optional;

import com.laundrovalley.rest.model.Plan;

public interface PlanService {

	public Plan addPlan(Plan plan);
	
	public ArrayList<Plan> getPlans();
	
	public Optional<Plan> getPlan(int id);
	
	
	
}
