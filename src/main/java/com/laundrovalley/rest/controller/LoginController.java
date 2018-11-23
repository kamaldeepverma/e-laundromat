package com.laundrovalley.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.laundrovalley.rest.model.Student;

@Controller
@SessionAttributes("stud")
public class LoginController {
	
	
	@ModelAttribute("stud")
	   public Student getStudent() {
	      return new Student();
	   }
	
	@PostMapping("doLogin")
	public ModelAndView doLogin(HttpSession session,@ModelAttribute Student stud,HttpServletRequest request,Model model) {
		
		ModelAndView mav = new ModelAndView();
		
		if(stud.getId().equals("2018H1120281P")&&stud.getPassword().equals("12345"))
		{
			
			mav.addObject("stud",stud);
			mav.addObject("mode", "MODE_HOME");
			mav.setViewName("home");
			
		}
		else {
			
			mav.addObject("error", "Invalid Username password");
			mav.addObject("mode", "MODE_LOGIN");
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("login")
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mode", "MODE_LOGIN");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session,HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		session.invalidate();
		return "index";
	}
}
