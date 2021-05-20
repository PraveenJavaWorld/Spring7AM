package com.nt.service;

import java.util.Set;

import com.nt.model.Customer;

public interface ICustomerMgmtService {
	
	public String registerCustomer(Customer cust);
	public Set<String> fetchAllCountries();
	public Set<String> fetchAllLanguages();

}
