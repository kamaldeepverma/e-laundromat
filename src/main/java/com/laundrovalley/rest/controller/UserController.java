package com.laundrovalley.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laundrovalley.rest.model.GeneratedIdResponse;
import com.laundrovalley.rest.model.Staff;
import com.laundrovalley.rest.model.Student;
import com.laundrovalley.rest.service.UserService;


@Controller
public class UserController {
	
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping("register-student")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "index";
	}
	
	/* to register a student*/
	@PostMapping("/do-register-student")
	public String createStudent(@ModelAttribute Student stud,BindingResult bindingResult,HttpServletRequest request) {
		
		//BaseResponse baseResponse
		System.out.println(stud);
		System.out.println(stud.getId());
		
		if(userService.addStudent(stud))
		{
			request.setAttribute("mode", "MODE_HOME");
			return "index";
				}
		System.out.println("hi");
		return "abc";

	}
	
	/* to register a staff*/
	@PostMapping("/staff")
	public ResponseEntity<GeneratedIdResponse> createStaff(@Valid @RequestBody Staff staff) {
		
		GeneratedIdResponse generatedIdResponse = userService.addStaff(staff);
		
		return new ResponseEntity<GeneratedIdResponse>(generatedIdResponse,HttpStatus.OK);
	}
	
	
	
	
	
        

}
