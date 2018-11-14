package com.laundrovalley.rest.service;


import com.laundrovalley.rest.model.BaseResponse;
import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.model.Student;


public interface UserService {
	
	public BaseResponse addStudent(Student stud);

	public GeneratedIdResponse addStaff(Staff staff);

	public String findByIdPassword(Student stud);
}
