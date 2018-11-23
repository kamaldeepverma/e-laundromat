package com.laundrovalley.rest.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import com.laundrovalley.rest.model.Student;


@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(@SessionAttribute("stud") Student stud,Model model,HttpServletRequest request) {
//		System.out.println(stud.getId());
//		
//		if(stud.getId().equals("2018H1120281P"))
//		{
//			model.addAttribute("stud",stud);
//			request.setAttribute("mode", "MODE_HOME");
//			return "home";
//		}
//		else
			System.out.println("abc");
			return "home";
	}
	
	
}
