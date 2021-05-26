package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishService;

@Controller
public class WishAppController {
	
	@Autowired
	private IWishService service;
	
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/wish")
	public String getMessage(Map<String,Object> map) {
		//use service
		String result = service.getMessage();
		//add result to map attribute
		map.put("msg", result);
		//return lvn
		return "result";
	}
	
}
