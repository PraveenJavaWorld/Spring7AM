package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;

@Controller
public class EmployeeReportController {
	
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public String generateReport(Map<String,Object> map,@RequestParam String type) {
		
		Employee emp1 = new Employee(1001, "Praveen", "Ramachandrapuram", "Java Developer", 40000.0f);
		Employee emp2 = new Employee(1002, "Rocky", "Hyderabad", "UI Developer", 20000.0f);
		Employee emp3 = new Employee(1003, "Praveen", "Ramachandrapuram", "PHP Developer", 30000.0f);
		Employee emp4 = new Employee(1004, "Rocky", "Hyderabad", "Python Developer", 70000.0f);
		List<Employee> listEmps = List.of(emp1, emp2,emp3,emp4);
		
		//keep data in model attribute
		map.put("listEmps", listEmps);
		
		//return lvn
		if(type.equalsIgnoreCase("pdf"))
			return "pdfReport";
		else
			return "excelReport";
		
	}

}
