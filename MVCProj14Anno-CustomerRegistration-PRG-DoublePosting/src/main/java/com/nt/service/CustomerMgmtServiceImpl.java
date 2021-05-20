package com.nt.service;

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

}
