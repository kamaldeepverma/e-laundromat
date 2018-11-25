package com.laundrovalley.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.laundrovalley.rest.model.Feedback;
import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.service.FeedbackService;

@CrossOrigin
@Controller
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	ModelAndView mav=new ModelAndView();
	Feedback feedback=new Feedback();
	@PostMapping("/feedback")
	public ResponseEntity<GeneratedIdResponse> provideFeedback(@Valid @RequestBody Feedback feedback){
		
		GeneratedIdResponse generatedIdResponse = feedbackService.addFeedback(feedback);
		
		return new ResponseEntity<GeneratedIdResponse>(generatedIdResponse,HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="feedback")
	public ModelAndView loadFeedbackPage() {
		System.out.println("please provide feedback");
		mav.addObject("mode","MODE_PROVIDE_FEEDBACK");
		mav.setViewName("home");
		return mav;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="savefeedback")
	public ModelAndView saveFeedback(@SessionAttribute("stud")Student stud, @RequestParam(value="description") String description) {
		
		feedback.setStudId(stud.getId());
		feedback.setDescription(description);
		System.out.println(description);
		feedbackService.addFeedback(feedback);
		mav.addObject("mode","MODE_HOME_FEEDBACK");
		mav.setViewName("home");
		
		return mav;
	}
	
}
