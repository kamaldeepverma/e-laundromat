package com.laundrovalley.rest.dao;


import java.util.Optional;

import com.laundrovalley.rest.model.Staff;


public interface StaffDAO {

	
	public Staff save(Staff staff);
	
	public Optional<Staff> findOne(String id);
}
