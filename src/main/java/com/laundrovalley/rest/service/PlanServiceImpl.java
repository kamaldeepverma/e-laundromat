package com.laundrovalley.rest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.PlanDAO;
import com.laundrovalley.rest.model.Plan;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	PlanDAO planDao;

	@Override
	public Plan addPlan(Plan plan) {
		return planDao.addPlan(plan);
		
	}

	@Override
	public ArrayList<Plan> getPlans() {
		
		return planDao.getPlans();
	}

	@Override
	public Plan getPlan(int id) {
		
		return planDao.getPlan(id);
	}

	

	
	
	
	

}
