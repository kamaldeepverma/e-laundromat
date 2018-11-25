package com.laundrovalley.rest.service;


import java.sql.Date;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.StudentDAO;
import com.laundrovalley.rest.dao.SubscriptionDAO;
import com.laundrovalley.rest.model.Notification;
import com.laundrovalley.rest.model.NotificationFactory;
import com.laundrovalley.rest.model.Plan;
import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.model.Subscription;
import com.laundrovalley.rest.repository.SubscriptionRepository;

@Service
@Component
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	SubscriptionDAO subscriptionDAO;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	PlanService planService;

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Autowired
	EmailService emailService;
	
	Subscription subscription = new Subscription();
		
	@Override
	public Subscription subscribePlan(String studentId,int planId,int duration) {
		
		
		
		Plan plan = planService.getPlan(planId);
		Calendar cal = Calendar.getInstance();
		//Subscription subscription = new Subscription();
		cal.add(Calendar.MONTH, duration);
		java.util.Date expiryDate = cal.getTime();
		java.sql.Date sqlExpiryDate = new java.sql.Date(expiryDate.getTime());
		subscription.setExpiry(sqlExpiryDate);
		subscription.setWashes(duration*plan.getWashes());
		subscription.setPlanId(planId);
		subscription.setStudentId(studentId);
		subscription.setStatus(true);
		subscription.setAmount(duration*plan.getAmount());
		subscriptionDAO.subscribePlan(subscription);
		
		return subscription;
	}

	@Override
	public Optional<Subscription> getSubscription(int id) {
		
		return subscriptionDAO.getSubscription(id);
	}
	
	
	//[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]
	@Scheduled(cron="0 58 20 * * ?")
	//@Scheduled(cron="0/20 * * * * ?")
	@Override
	public void notifyExpiry() {
		System.out.println("scheduled Job running");
			
		LocalDateTime today=LocalDateTime.now();
		System.out.println(today.toString().substring(0, 10));
		ArrayList<Subscription> subscriptions= new ArrayList<>();
		subscriptions=subscriptionDAO.getSubcriptions();
		Student student=new Student();
		Notification notification = NotificationFactory.getNotificationInstance("expiry");
		
		for(Subscription subscription : subscriptions) {
			int daysLeft=getDaysLeft(subscription.getExpiry(), Date.valueOf(today.toString().substring(0, 10)));
			subscription.getId();
			student =studentDAO.getStudent(subscription.getStudentId());
			
			
			if(daysLeft >=0 && daysLeft<3 ) {	
				System.out.println("108 " + subscription);
				notification.constructMessage(student.getEmail(), student.getName(), subscription.getExpiry().toString());
				emailService.sendEmail(notification);
				
			}
			
		}
		
	}	
	

	@Override
	public int getDaysLeft(Date expiry, Date today) {
		
		String date1=expiry.toString();
		String date2=today.toString();
		System.out.println("date1: " + date1);
		System.out.println("date2: " + date2);
		
		int expiryDate=Integer.valueOf(date1.substring(8, 9));
		int todaysDate=Integer.valueOf(date2.substring(8, 9));
		int expiryMonth=Integer.valueOf(date1.substring(5, 6));
		int currentMonth=Integer.valueOf(date2.substring(5, 6));
		int expiryYear= Integer.valueOf(expiry.toString().substring(0, 3));
		
		
		int currentYear=Integer.valueOf(today.toString().substring(0, 3));
		if(expiryYear-currentYear>=0)
			if(expiryMonth-currentMonth>=0) {
				return todaysDate-expiryDate;
			}
		return -1;
	} 

	@Override
	public boolean getStatus(String id) {
		
		Subscription subscription = subscriptionRepository.getSubscription(id);
		if(subscription!=null)
			return true;
		else
			return false;
	}

}
