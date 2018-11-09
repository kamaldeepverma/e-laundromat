package com.laundrovalley.rest.dao;

import java.util.Optional;

import com.laundrovalley.rest.model.Student;


public interface StudentDAO {

	public Student save(Student stud);
	
	public Optional<Student> findOne(String id); 
	
}
