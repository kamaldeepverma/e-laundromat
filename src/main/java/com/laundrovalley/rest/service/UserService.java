package com.laundrovalley.rest.service;


import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.model.Student;


public interface UserService {
	
	public Boolean addStudent(Student stud);

	public GeneratedIdResponse addStaff(Staff staff);

	public Student loginUser(Student stud);
	
	public String generateHash(String password);
	
	public Staff loginStaff(Staff staff);
}
