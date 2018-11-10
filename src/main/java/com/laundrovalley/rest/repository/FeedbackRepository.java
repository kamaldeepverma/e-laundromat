package com.laundrovalley.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundrovalley.rest.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
