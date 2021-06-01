package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public Iterable<Employee> fetchAllEmps() {
		return repo.findAll();
	}
	
	@Override
	public String insertEmployee(Employee emp) {
		Employee emp1 = repo.save(emp);
		if(emp1!=null)
			return "Employee Registered Successfully";
		else
			return "Problem in Employee Registeration";
	}
	
	@Override
	public Employee fetchEmployeeById(int id) {
		//use repo
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get(); //return Employee
		else
			return null;
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		Employee emp1 = repo.save(emp);
		if(emp1!=null)
			return "Employee Updated Successfully";
		else
			return "Problem in Employee of ID "+emp.getId()+" Updation";
	}
	
	@Override
	public void deleteEmployeeById(int id) {
		//use repo
		repo.deleteById(id);
	}
	
	@Override
	public Page<Employee> getPageData(Pageable pageable) {
		//use service
		Page<Employee> page = repo.findAll(pageable);
		return page;
	}

}
