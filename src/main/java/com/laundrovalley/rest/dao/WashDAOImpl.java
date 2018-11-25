package com.laundrovalley.rest.dao;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Wash;
import com.laundrovalley.rest.repository.WashRepository;

@Transactional
@Service
public class WashDAOImpl implements WashDAO{

	@Autowired
	WashRepository washRepository;
	
	
	@Override
	public Wash ScheduleWash(Wash wash) {
		Wash tempWash=new Wash();
			tempWash=washRepository.getWash(wash.getStudentId());
			System.out.println(tempWash+"dao");
			if(tempWash==null)
			{	System.out.println("hiii");
			//return null;
				return washRepository.save(wash);
			}
				return null;
			
	
	}


	@Override
	public ArrayList<Wash> getWashes() {
		return washRepository.getWashes();
	}

@Override
	public List<Wash> getWashes(Date scheduledDate) {
		
		return washRepository.findWashesByDate(scheduledDate); 
	
	}
	
	@Override
	public void updateStatus(int washId, String status) {
		
		System.out.println(washRepository.updateStatus(washId, status));
	}

}
