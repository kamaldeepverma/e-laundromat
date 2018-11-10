package com.laundrovalley.rest.service;

import com.laundrovalley.rest.model.Feedback;
import com.laundrovalley.rest.model.GeneratedIdResponse;

public interface FeedbackService {

	public GeneratedIdResponse addFeedback(Feedback feedback);
}
