package com.laundrovalley.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.FeedbackDAO;
import com.laundrovalley.rest.model.Feedback;
import com.laundrovalley.rest.model.GeneratedIdResponse;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDAO feedbackDAO;
	
	@Override
	public GeneratedIdResponse addFeedback(Feedback feedback) {
		Feedback tempFeedback = feedbackDAO.addFeedback(feedback);
		String feedbackId = tempFeedback.getId().toString();
		return new GeneratedIdResponse(feedbackId);
	}

}
