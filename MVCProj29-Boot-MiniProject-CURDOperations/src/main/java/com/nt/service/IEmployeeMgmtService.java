package com.nt.service;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	
	public Iterable<Employee> fetchAllEmps();
	public String insertEmployee(Employee emp);
	public Employee fetchEmployeeById(int id);
	public String updateEmployee(Employee emp);
	public void deleteEmployeeById(int id);

}
