package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public int register(EmployeeDTO dto) {
		//convert dto to entity
		Employee entity = new Employee();
		BeanUtils.copyProperties(dto, entity);
		//use empRepo
		Employee entity1 = empRepo.save(entity);
		return entity1.getEid();
		//return empRepo.save(entity).getEid();
	}

}
