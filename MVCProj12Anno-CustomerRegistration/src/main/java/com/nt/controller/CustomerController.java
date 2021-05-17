package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerMgmtService service;
	
	@GetMapping("/form")
	public String showForm(@ModelAttribute("cust") Customer cust) {
		//add initial form data
		cust.setAddress("RCPM");
		//return lvn
		return "customer_form";
	}
	
	@PostMapping("/customer")
	public String insertCustomer(Map<String, Object> map,@ModelAttribute("cust") Customer cust) {
		//use service
		String msg = service.registerCustomer(cust);
		//keep msg in Model Attribute
		map.put("msg", msg);
		return "result";
	}

}
