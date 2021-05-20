package com.nt.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String insertCustomer(RedirectAttributes redirect,@ModelAttribute("cust") Customer cust,BindingResult errors) {
		
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
		redirect.addFlashAttribute("msg", msg);
		redirect.addFlashAttribute("modelData", cust);
		return "redirect:show";
	}
	
	@GetMapping("/show")
	public String showResult() {
		return "result";
	}
	
	//reference data using Model Attribute
	@ModelAttribute("gendersList")
	public List<String> genders(){
		return List.of("male","female");
	}
	
	@ModelAttribute("hobbiesList")
	public List<String> hobbies(){
		return List.of("Reading Books","Watching TV","Sleeping","Playing PUBG","Coding");
	}
	
	@ModelAttribute("countriesList")
	public Set<String> countries(){
		Set<String> countriesSet = service.fetchAllCountries();
		return countriesSet;
	}
	
	@ModelAttribute("languagesList")
	public Set<String> languages(){
		Set<String> languagesSet = service.fetchAllLanguages();
		return languagesSet;
	}

}
