package com.laundrovalley.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.laundrovalley.rest.model.Student;

@Controller
//@SessionAttributes("stud")
public class LoginController {
	
	
	@ModelAttribute("stud")
	   public Student getStudent() {
	      return new Student();
	   }
	
	@PostMapping("doLogin")
	public String doLogin(HttpSession session,@ModelAttribute Student stud,HttpServletRequest request,Model model) {
		
		if(stud.getId().equals("2018H1120281P")&&stud.getPassword().equals("12345"))
		{
			model.addAttribute("stud",stud);
			session.setAttribute("stud", stud);
		}
		else {
			request.setAttribute("error", "Invalid Username password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "index";
		}
		request.setAttribute("mode", "MODE_HOME");
		return "home";
	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "index";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session,HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		session.invalidate();
		return "index";
	}
}
