package com.nt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	private IWishMessageService service;
	
	@RequestMapping("/welcome")
	public String showHome() {
		return "home";//lvn
	}
	
	
	
	@RequestMapping("/wish")
	public String getMessage(Map<String,Object> map) {         // Best 
		//use service
		String msg = service.generateMsg();
		System.out.println(map.getClass());
		//return map obj
		map.put("sysDate", new Date());
		map.put("showMsg", msg);
		return "result";
	}
	
	
}
