package com.laundrovalley.rest.dao;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.laundrovalley.rest.model.Wash;

public interface WashDAO {
	
	
	public Wash ScheduleWash(Wash wash);

	public ArrayList<Wash> getWashes();

	public void updateStatus(int washId, String status);
	
	public List<Wash> getWashes(Date scheduledDate);

}
