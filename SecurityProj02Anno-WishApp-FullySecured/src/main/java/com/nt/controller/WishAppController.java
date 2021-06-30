package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishAppMgmtService;

@Controller
public class WishAppController {
	
	@Autowired
	private IWishAppMgmtService service;
	
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/wish")
	public String showWishMsg(Map<String,Object> map) {
		//use Service
		String result = service.getMessage();
		//add attribute
		map.put("showMsg", result);
		map.put("sysDate", new Date());
		//return lvn
		return "result";
	}

}
