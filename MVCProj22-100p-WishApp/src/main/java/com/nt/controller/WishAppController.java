package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishAppController {
	
	@Autowired
	private IWishMessageService service;
	
	@RequestMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/wish")
	public String wishMsg(Map<String,Object> map) {
		//use service
		String result = service.generateMessage();
		// add result to map attribute
		map.put("msg", result);
		//return lvn
		return "result";
	}

}
