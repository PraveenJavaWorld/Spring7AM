package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;
import com.nt.validation.CustomerValidation;

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerMgmtService service;
	
	@Autowired
	private CustomerValidation validator;
	
	@GetMapping("/form")
	public String showForm(@ModelAttribute("cust") Customer cust) {
		//add initial form data
		cust.setAddress("RCPM");
		//return lvn
		return "customer_form";
	}
	
	@PostMapping("/customer")
	public String insertCustomer(Map<String, Object> map,@ModelAttribute("cust") Customer cust,BindingResult errors) {
		
		//perform server side form validations when client side is not done
		if(cust.getVflag().equalsIgnoreCase("no")) {
			//perform form validations
			if(validator.supports(cust.getClass()))
				validator.validate(cust, errors);
			
			if(errors.hasErrors()) // if errors are there in form return lvn 
				return "customer_form";
		}//if
		
		//Application Logic Errors
		if(cust.getBillAmount()>=100000) {
			errors.rejectValue("billAmount", "billAmount.big");
			return "customer_form";
		}
		
		//use service
		String msg = service.registerCustomer(cust);
		//keep msg in Model Attribute
		map.put("msg", msg);
		return "result";
	}

}
