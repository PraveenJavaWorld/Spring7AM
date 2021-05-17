package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	/*@RequestMapping("/welcome")
	public String showHome1() {
		return "home";
	}
	
	@RequestMapping("/register")
	public String saveData1() {
		return "result1";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String saveData2() {
		return "result2";
	}*/ // 1
		
	/*@RequestMapping(value = {"welcome","home","index"})
	public String showHome() {
		return "home";
	}*/  // 2
	
	@RequestMapping("/save")
	public String saveEmp() {
		return "redirect:showEmps";
	}
	
	@RequestMapping("/delete")
	public String deleteEmp() {
		return "redirect:showEmps";
	}
	
	/*@RequestMapping("/showEmps")
	public String listEmps() {
		return "show";
	}*/

}
