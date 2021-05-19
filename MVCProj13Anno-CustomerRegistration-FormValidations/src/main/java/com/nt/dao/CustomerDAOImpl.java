package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Customer;

@Repository("dao")
public class CustomerDAOImpl implements ICustomerDAO {
	
	private static final String CUSTOMER_INSERT = "INSERT INTO MVC_CUSTOMER VALUES(MVC_CUSTOMER_SEQ.NEXTVAL,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int saveCustomer(Customer cust) {
		int result = jt.update(CUSTOMER_INSERT,cust.getName(),cust.getAddress(),cust.getBillAmount());
		return result;
	}

}
