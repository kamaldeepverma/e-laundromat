package com.laundrovalley.rest.service;


import java.sql.Date;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.StudentDAO;
import com.laundrovalley.rest.dao.SubscriptionDAO;
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
		
	@Override
	public Subscription subscribePlan(String studentId,int planId,int duration) {
		
		
		
		Plan plan = planService.getPlan(planId);
		Calendar cal = Calendar.getInstance();
		Subscription subscription = new Subscription();
		cal.add(Calendar.MONTH, duration);
		java.util.Date expiryDate = cal.getTime();
		java.sql.Date sqlExpiryDate = new java.sql.Date(expiryDate.getTime());
		subscription.setExpiry(sqlExpiryDate);
		subscription.setWashes(duration*plan.getWashes());
		subscription.setPlanId(planId);
		subscription.setStudentId(studentId);
		subscription.setStatus(true);
		subscription.setAmount(duration*plan.getAmount());
		System.out.println("service:68");
		subscriptionDAO.subscribePlan(subscription);
		
		return subscription;
	}

	@Override
	public Optional<Subscription> getSubscription(int id) {
		
		return subscriptionDAO.getSubscription(id);
	}
	
	
	//[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]
	@Scheduled(cron="0 58 20 * * ?")
	@Override
	public void notifyExpiry() {
		System.out.println("scheduled Job running");
			
		LocalDateTime today=LocalDateTime.now();
		System.out.println(today.toString().substring(0, 10));
		ArrayList<Subscription> subscriptions= new ArrayList<>();
		subscriptions=subscriptionDAO.getSubcriptions();
		Student student=new Student();
		
		System.out.println(subscriptions);
		for(Subscription subscription : subscriptions) {
			int daysLeft=getDaysLeft(subscription.getExpiry(), Date.valueOf(today.toString().substring(0, 10)));
			subscription.getId();
			student =studentDAO.getStudent(subscription.getStudentId());
			if(daysLeft >=0 && daysLeft<3 ) {
				
				try {
					sendEmail(student,subscription);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}	
	
	@Override
	public void sendEmail(Student student,Subscription subscription) throws MessagingException {
		String to = student.getEmail();
		String password= "yashratnaniyash11";
		      
		String from = "yashratnani1@gmail.com";
	    String host = "smtp.gmail.com";  
		                 
		final String username = "yashratnani1@gmail.com";
		      
			  System.out.println("TLSEmail Start"); 
		              
	          Properties properties = System.getProperties();
              properties.setProperty("mail.smtp.host", host); 
              properties.put("mail.smtp.port", "465");  
              properties.put("mail.smtp.starttls.enable", "true");
              properties.put("mail.smtp.auth", "true");  
                
              // SSL Factory 
              properties.put("mail.smtp.socketFactory.class", 
                      "javax.net.ssl.SSLSocketFactory");  
              Session session = Session.getInstance(properties, 
                  new javax.mail.Authenticator() { 
                        
                      protected PasswordAuthentication  
                              getPasswordAuthentication() { 
                          return new PasswordAuthentication(username, 
                                                          password); 
                      } 
                  }); 
        
      try { 
          MimeMessage message = new MimeMessage(session);  
            
          message.setFrom(new InternetAddress(from)); 
            
          message.addRecipient(Message.RecipientType.TO,  
                                new InternetAddress(to)); 
          message.setSubject("Expiration Notification"); 
          message.setText(" Hello ,"+student.getName()+"\n Your subscription is expiring on"+subscription.getExpiry());
        
          //Transport trans=session.getTransport("smtp");
          Transport.send(message); 
          System.out.println("Yo it has been sent.."); 
      } 
      catch (MessagingException mex) { 
          mex.printStackTrace(); 
      } 
      }

	@Override
	public int getDaysLeft(Date expiry, Date today) {
		
		String date1=expiry.toString();
		String date2=today.toString();
		int expiryDate=Integer.valueOf(date1.substring(9, 10));
		int todaysDate=Integer.valueOf(date2.substring(9, 10));
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
