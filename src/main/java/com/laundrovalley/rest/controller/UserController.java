package com.laundrovalley.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.laundrovalley.rest.model.BaseResponse;
import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	/* to register a student*/
	@PostMapping("/student")
	public ResponseEntity<BaseResponse> createStudent(@Valid @RequestBody Student stud) {
		
		BaseResponse baseResponse = userService.addStudent(stud);
		
		return new ResponseEntity<BaseResponse>(baseResponse,HttpStatus.OK);
	}
	
	/* to register a staff*/
	@PostMapping("/staff")
	public ResponseEntity<GeneratedIdResponse> createStaff(@Valid @RequestBody Staff staff) {
		
		GeneratedIdResponse generatedIdResponse = userService.addStaff(staff);
		
		return new ResponseEntity<GeneratedIdResponse>(generatedIdResponse,HttpStatus.OK);
	}
	
        

}
