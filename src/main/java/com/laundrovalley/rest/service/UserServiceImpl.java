package com.laundrovalley.rest.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.dao.StaffDAO;
import com.laundrovalley.rest.dao.StudentDAO;
import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.model.Student;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	StaffDAO staffDAO;
	
	@Override
	public Boolean addStudent(Student stud) {
		stud.setPassHash(generateHash(stud.getPassword()));
		
			return studentDAO.save(stud);
		
	}

	public GeneratedIdResponse addStaff(Staff staff) {
		staff.setId("S"+staff.getPhone());
		staff.setPassHash(staff.getPassword());
		staffDAO.save(staff);
		return new GeneratedIdResponse(staff.getId());
	}

	@Override
	public Student loginUser(Student stud) {
		stud.setPassHash(generateHash(stud.getPassword()));
		return studentDAO.loginUser(stud.getId(), stud.getPassHash());
	}

	@Override
	public String generateHash(String password) {
		String hashedPassword="";
		try {
			byte[] hash=password.getBytes(StandardCharsets.UTF_8);
			MessageDigest digest= MessageDigest.getInstance("SHA-256");
			byte[] hashedbytes=digest.digest(hash);
			 hashedPassword = Base64.getEncoder().encodeToString(hashedbytes);
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		return hashedPassword;
	}

	@Override
	public Staff loginStaff(Staff staff) {
		
		return staffDAO.findOne(staff.getId());
		
	}


	}

