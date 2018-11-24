package com.laundrovalley.rest.dao;


import com.laundrovalley.rest.model.Student;


public interface StudentDAO {

	public Boolean save(Student stud);
	

	public Student loginUser(String id,String password);

	public Student findOne(String id);

	public String findByIdPassword(Student stud); 
	
	public Student getStudent(String id);
	
}
