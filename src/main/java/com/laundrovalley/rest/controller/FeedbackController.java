package com.laundrovalley.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laundrovalley.rest.model.Feedback;
import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.service.FeedbackService;

@CrossOrigin
@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/feedback")
	public ResponseEntity<GeneratedIdResponse> provideFeedback(@Valid @RequestBody Feedback feedback){
		
		GeneratedIdResponse generatedIdResponse = feedbackService.addFeedback(feedback);
		
		return new ResponseEntity<GeneratedIdResponse>(generatedIdResponse,HttpStatus.OK);
		
	}
}
