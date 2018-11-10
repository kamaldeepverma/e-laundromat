package com.laundrovalley.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Feedback;
import com.laundrovalley.rest.repository.FeedbackRepository;

@Service
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		
		return feedbackRepository.save(feedback);
		
	}

}
