package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	
	public Iterable<Employee> fetchAllEmps();
	public String insertEmployee(Employee emp);
	public Employee fetchEmployeeById(int id);
	public String updateEmployee(Employee emp);
	public void deleteEmployeeById(int id);
	public Page<Employee> getPageData(Pageable pageable);

}
