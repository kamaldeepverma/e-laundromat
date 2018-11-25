package com.laundrovalley.rest.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.repository.StudentRepository;

@Service
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	StudentRepository studentRepository;
	
	

	@Override
	public Student findOne(String id) {
		return studentRepository.findById(id)
				.orElse(new Student());	
	}



	@Override
	public Boolean save(Student stud) {
		System.out.println("IN Save");
		System.out.println(stud.getId());
		
		if(studentRepository.existsById(stud.getId()))
		{	
			
			System.out.println("reached here");
			return false;
			
		}
			
			 studentRepository.save(stud);
			 return true;
	
	}



	@Override
	public String findByIdPassword(Student stud) {
		//Optional<Student> temp = studentRepository.findById(stud.getId());
		
		
		return null;
	}



	@Override
	public Student loginUser(String id, String password) {
		return studentRepository.loginUser(id, password);
		
	}



	@Override
	public Student getStudent(String id) {
		
		return studentRepository.findById(id).orElse(null);
	}



	



	
}
