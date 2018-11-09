package com.laundrovalley.rest.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.repository.StudentRepository;

@Service
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	StudentRepository studentRepository;
	
	public Student save(Student stud) {
		return null;
	}
	
	public Optional<Student> findOne(String id) {
		return null;
	}
}
