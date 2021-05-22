package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeReportController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public String generateReport(Map<String,Object> map,@RequestParam String type) {
		
		
		List<Employee> listEmps = service.fetchEmps();
		
		//keep data in model attribute
		map.put("listEmps", listEmps);
		
		//return lvn
		if(type.equalsIgnoreCase("pdf"))
			return "pdfReport";
		else
			return "excelReport";
		
	}

}
