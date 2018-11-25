package com.laundrovalley.rest.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.model.Wash;
import com.laundrovalley.rest.repository.SubscriptionRepository;
import com.laundrovalley.rest.service.WashService;

@Controller
public class WashController {

	@Autowired
	WashService washService;
	
	@Autowired
	SubscriptionRepository subscriptionRepo;
	ModelAndView modelView=new ModelAndView();
	@RequestMapping("/loadScheduleWash")
	public ModelAndView loadScheduleWash(@SessionAttribute("stud") Student stud) {
		if(subscriptionRepo.getSubscription(stud.getId())==null)
				{
				modelView.addObject("mode","NOT_SUBSCRIBED");
				modelView.setViewName("home");
				return modelView;
				}
		modelView.setViewName("home");
		modelView.addObject("mode","SCHEDULE_WASH");
		return modelView;
		
		
	}

	@RequestMapping("/schedule-wash")
	public ModelAndView scheduleWash(@SessionAttribute("stud") Student stud, @RequestParam("quantity") String quantity)
	{
		Date temp;
		temp = washService.scheduleWash(Integer.valueOf(quantity), stud.getId());
		System.out.println("35 controller"+temp);
		if(temp==null) {
			modelView.setViewName("home");
			modelView.addObject("mode","NOT_SCHEDULED");
			
			return modelView; 
		}
		modelView.setViewName("home");
		modelView.addObject("mode", "WASH_SCHEDULED");
		modelView.addObject("deliverdate",temp);
		return modelView;
	}
		
		
	
	
	@RequestMapping("/washes")
	public ModelAndView listWashes() {
		
		ArrayList<Wash> washes = washService.getWashes();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("washes",washes);
		mav.addObject("mode", "MODE_STAFF_LIST_WASH");
		mav.setViewName("home-staff");
		return mav;
		
	}
	
	@PostMapping("/change-status")
	public ModelAndView changeStatus(@RequestParam("washId") int washId,@RequestParam("studentId") String studentId,@RequestParam("status") String status) {
		
		washService.changeStatus(washId,studentId,status);
		
		ArrayList<Wash> washes = washService.getWashes();
		System.out.println("status"+status);
		ModelAndView mav = new ModelAndView();
		mav.addObject("washes",washes);
		mav.addObject("mode", "MODE_STAFF_LIST_WASH");
		mav.setViewName("home-staff");
		
		return mav;
		
	}
	
}
