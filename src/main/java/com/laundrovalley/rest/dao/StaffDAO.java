package com.laundrovalley.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.repository.StaffRepository;

@Service
public class StaffDAO {

	@Autowired
	StaffRepository staffRepository;
	
	public Staff save(Staff staff) {
		return staffRepository.save(staff);
	}
	
	public Staff findOne(String id) {
		return staffRepository.findOne(id);
	}
}
