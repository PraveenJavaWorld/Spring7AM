package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;

@Service("service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private ICustomerDAO dao;

	@Override
	public String registerCustomer(Customer cust) {
		int result = dao.saveCustomer(cust);
		return (result==0)?"Customer Registration Failed":"Customer Registration Succeed";
	}

	@Override
	public Set<String> fetchAllCountries() {
		Locale locale[] = Locale.getAvailableLocales();
		Set<String> countriesSet = new TreeSet<>();
		for(Locale l:locale) {
			countriesSet.add(l.getDisplayCountry());
		}
		return countriesSet;
	}

	@Override
	public Set<String> fetchAllLanguages() {
		Locale locale[] = Locale.getAvailableLocales();
		Set<String> languagesSet = new TreeSet<>();
		for(Locale l:locale) {
			languagesSet.add(l.getDisplayLanguage());
		}
		return languagesSet;
	}

}
