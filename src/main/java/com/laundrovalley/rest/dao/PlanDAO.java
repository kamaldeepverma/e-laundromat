package com.laundrovalley.rest.dao;

import java.util.ArrayList;


import com.laundrovalley.rest.model.Plan;

public interface PlanDAO {

	public Plan addPlan(Plan plan);
	
	public ArrayList<Plan> getPlans();
	
	public Plan getPlan(int id);
	
}
