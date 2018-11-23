package com.laundrovalley.rest.dao;



import com.laundrovalley.rest.model.Student;


public interface StudentDAO {

	public Student save(Student stud);
	
	public Student findOne(String id);

	public String findByIdPassword(Student stud); 
	
}
