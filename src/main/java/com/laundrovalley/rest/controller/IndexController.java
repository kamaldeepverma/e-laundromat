package com.laundrovalley.rest.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.laundrovalley.rest.service.UserService;

@Controller
public class IndexController {
	
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME"); 
		return "index";
	}
	
	
	@RequestMapping("index")
	public String welcome(HttpServletRequest request) {
		 request.setAttribute("mode", "MODE_HOME");
		return "index";
	}


}
