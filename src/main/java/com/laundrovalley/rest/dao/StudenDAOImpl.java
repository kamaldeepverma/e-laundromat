package com.laundrovalley.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.repository.StudentRepository;

@Service
public class StudenDAOImpl {

	@Autowired
	StudentRepository studentRepository;
	
	public Student save(Student stud) {
		return studentRepository.save(stud);
	}
	
	public Student findOne(String id) {
		return studentRepository.findOne(id);
	}
}
