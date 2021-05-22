package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {
	
	@Autowired
	private IWishMessageService service;
	
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/wish")
	public String getMessage(Map<String,Object> map) {
		//use service
		String msg = service.generateWishMessage();
		map.put("sysDate", new Date());
		map.put("msg", msg);
		return "result";
	}

}
