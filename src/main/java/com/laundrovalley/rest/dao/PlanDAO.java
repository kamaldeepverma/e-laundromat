package com.laundrovalley.rest.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.laundrovalley.rest.model.Plan;

public interface PlanDAO {

	public Plan addPlan(Plan plan);
	
	public ArrayList<Plan> getPlans();
	
	public Optional<Plan> getPlan(int id);
	
}
