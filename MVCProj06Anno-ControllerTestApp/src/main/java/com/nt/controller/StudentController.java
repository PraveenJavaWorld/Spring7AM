package com.nt.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private ServletConfig cg;
	
	@RequestMapping("/showEmps")
	public String listEmps(HttpSession ses,HttpServletRequest req) {
		System.out.println("Dispalying Employees");
		System.out.println("Web App Name :: "+sc.getContextPath());
		System.out.println("Web App Path :: "+sc.getRealPath("/"));
		System.out.println("Dispatche Servlet Logical Name :: "+cg.getServletName());
		System.out.println("Session ID :: "+ses.getId());
		System.out.println("Request URI :: "+req.getRequestURI());
		return "show";
	}

}
