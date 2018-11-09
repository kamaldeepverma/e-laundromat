package com.laundrovalley.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.StaffDAO;
import com.laundrovalley.rest.dao.StudentDAO;
import com.laundrovalley.rest.model.BaseResponse;
import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.model.Student;

@Service
public class UserService {

	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	StaffDAO staffDAO;
	
	public BaseResponse addStudent(Student stud) {
		stud.setPassHash(stud.getPassword());
		
		try {
		
			studentDAO.save(stud);
		
		}catch(DataIntegrityViolationException ex) {
			return new BaseResponse("User Exists", 1);
		}catch(Exception ex) {
			return new BaseResponse("Unknown Error: "+ ex.getClass().getName(), 2);
		}
		
		return new BaseResponse("Success", 0);
	}

	public GeneratedIdResponse addStaff(Staff staff) {
		staff.setId("S"+staff.getPhone());
		staff.setPassHash(staff.getPassword());
		staffDAO.save(staff);
		return new GeneratedIdResponse(staff.getId());
	}
}
