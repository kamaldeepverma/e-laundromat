package com.laundrovalley.rest.service;

import java.util.ArrayList;


import com.laundrovalley.rest.model.Plan;

public interface PlanService {

	public Plan addPlan(Plan plan);
	
	public ArrayList<Plan> getPlans();
	
	public Plan getPlan(int id);
	
	
	
}
