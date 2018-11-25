package com.laundrovalley.rest.service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.laundrovalley.rest.model.Wash;

public interface WashService {

		
		public Date scheduleWash(int quantity,String studId);
		public List<Wash> findWashesByDate(Date date);
		public Date getDeliveryDate(Date scheduledDate);
		public ArrayList<Wash> getWashes();

		public boolean changeStatus(int washId, String studentId, String status);
	
}
