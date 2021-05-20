package com.nt.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Customer;

@Component("validator")
public class CustomerValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Customer.class); //To check if correct model class is coming or not
	}

	@Override
	public void validate(Object target, Errors errors) {
		//type casting
		Customer cust = (Customer) target;
		//form validation logics(Server Side)
		//for name
		if(cust.getName()==null || cust.getName().isBlank())
			errors.rejectValue("name", "name.required");
		else if(cust.getName().length()<5)
			errors.rejectValue("name", "name.minlen");
		
		//for address
		if(cust.getAddress()==null || cust.getAddress().isBlank())
			errors.rejectValue("address", "address.required");
		else if(cust.getAddress().length()<8)
			errors.rejectValue("address", "address.minlen");
		
		//for billAmount
		if(cust.getBillAmount()==null)
			errors.rejectValue("billAmount", "billAmount.required");
		else if(cust.getBillAmount()<=0)
			errors.rejectValue("billAmount", "billAmount.positive");

	}

}
