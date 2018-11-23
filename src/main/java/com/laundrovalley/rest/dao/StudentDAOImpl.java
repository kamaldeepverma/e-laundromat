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
	public Student save(Student stud) {
		return studentRepository.save(stud);
	}



	@Override
	public String findByIdPassword(Student stud) {
		//Optional<Student> temp = studentRepository.findById(stud.getId());
		
		
		return null;
	}

}
