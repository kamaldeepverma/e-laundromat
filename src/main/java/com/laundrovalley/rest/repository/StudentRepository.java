package com.laundrovalley.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundrovalley.rest.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
