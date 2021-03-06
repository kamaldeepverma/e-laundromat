package com.laundrovalley.rest.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Plan;
import com.laundrovalley.rest.repository.PlanRepository;

@Service
public class PlanDAOImpl implements PlanDAO{
	
	@Autowired
	PlanRepository planRepo;
	
	@Override
	public Plan addPlan(Plan plan) {
		if(!planRepo.existsById(plan.getId())) {
			System.out.println("in method");
		return planRepo.save(plan);
		}
		return null;
	}

	@Override
	public ArrayList<Plan> getPlans() {
		
		return (ArrayList<Plan>) planRepo.findAll();
		
	}

	@Override
	public Plan getPlan(int id) {
		
		return planRepo.findById(id)
				.orElse(null);
	}

	
		
	}



