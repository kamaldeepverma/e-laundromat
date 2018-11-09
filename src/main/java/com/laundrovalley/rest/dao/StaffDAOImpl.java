package com.laundrovalley.rest.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.repository.StaffRepository;

@Service
public class StaffDAOImpl implements StaffDAO{

	@Autowired
	StaffRepository staffRepository;
	
	
	
	public Optional<Staff> findOne(String id) {
		return staffRepository.findById(id);
	}



	@Override
	public Staff save(Staff staff) {
		return staffRepository.save(staff);
	}
<<<<<<< HEAD
=======
	
	public Optional<Staff> findOne(String id) {
		return staffRepository.findById(id);
	}
>>>>>>> refs/remotes/laundrovalley/master
}
