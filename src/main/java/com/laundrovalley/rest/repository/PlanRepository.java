package com.laundrovalley.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundrovalley.rest.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
