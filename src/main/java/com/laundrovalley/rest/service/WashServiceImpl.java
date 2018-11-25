package com.laundrovalley.rest.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.StudentDAO;
import com.laundrovalley.rest.dao.SubscriptionDAO;
import com.laundrovalley.rest.dao.WashDAO;
import com.laundrovalley.rest.model.Notification;
import com.laundrovalley.rest.model.NotificationFactory;
import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.model.Wash;

@Service
public class WashServiceImpl implements WashService{

	@Autowired
	WashDAO washDAO;
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	SubscriptionDAO subscriptionDAO;
	
	Wash wash=new Wash();
	
	@Override
	public Date scheduleWash(int quantity,String studId) {
		LocalDateTime today=LocalDateTime.now();
		System.out.println(today);
		wash.setQuanitity(quantity);
		System.out.println(Date.valueOf(today.toString().substring(0, 10))+"at 28");
		wash.setScheduledDate(Date.valueOf(today.toString().substring(0, 10)));
		wash.setStatus("scheduled");
		wash.setStudentId(studId);
		wash.setDeliveryDate(getDeliveryDate(wash.getScheduledDate()));
		if(washDAO.ScheduleWash(wash)==null)
		{ System.out.println("at 34 returing");
			return null;
		}
			System.out.println("at scheduleWash 35");
		return wash.getDeliveryDate();
		
	}
	

	@Override
	public ArrayList<Wash> getWashes() {
		return washDAO.getWashes();
		
	}

	@Override
	public boolean changeStatus(int washId,String studentId, String status) {
		
		washDAO.updateStatus(washId,status);
		Student student = studentDAO.findOne(studentId);
		Notification notification = NotificationFactory.getNotificationInstance("status");
		notification.constructMessage(student.getEmail(), student.getName(), status);
		emailService.sendEmail(notification);
		
		if(status.equalsIgnoreCase("completed"))
			subscriptionDAO.decreaseWashCount(studentId);
		
		return true;
	}


@Override
	public Date getDeliveryDate(Date scheduledDate) {
		System.out.println("at 41 getDelDate");
		Date tempDate;
		String scheduled=scheduledDate.toString();
		String year,month,date;
		year=scheduled.substring(0, 4);
		month=scheduled.substring(5,7);
		date=scheduled.substring(8,10);
		int tempdate=Integer.valueOf(date);
		tempDate=scheduledDate;
		ArrayList<Wash> washes=new ArrayList<>();
		washes=(ArrayList<Wash>) findWashesByDate(scheduledDate);
		System.out.println(washes.size());
		System.out.println(year+"-"+month+"-"+date);
		if(washes.size()>9)
		{
			tempdate=tempdate+1;
			
		}
		date=String.valueOf(tempdate);
		tempDate=Date.valueOf(year+"-"+month+"-"+date);
		System.out.println(tempDate+"at 60");
		return tempDate;
	}

	@Override
	public List<Wash> findWashesByDate(Date date) {
		
		return washDAO.getWashes(date); 
	}
	
	
}
