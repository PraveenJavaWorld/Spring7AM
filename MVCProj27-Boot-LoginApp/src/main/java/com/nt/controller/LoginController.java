package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.User;
import com.nt.service.ILoginService;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginService service;
	
	@GetMapping("/")
	public String launchWelcomeFile() {
		return "redirect:form";
	}
	
	@GetMapping("/form")
	public String showForm(@ModelAttribute("userForm") User user) {
		return "login_form";
	}
	
	@PostMapping("/login")
	public String processFrom(Map<String,Object> map,@ModelAttribute("userForm") User user) {
		//use service
		String result = service.validate(user);
		//add result to map attribute
		map.put("msg", result);
		//return lvn
		return "login_form";
	}

}
