package com.laundrovalley.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laundrovalley.rest.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	@Query("from Student where id=?1 And passHash=?2")
	public Student loginUser(String id, String password);

	
}
