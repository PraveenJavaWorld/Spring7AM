package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("service")
public class EmployeeMgmtService implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmps() {
		//use dao
		List<EmployeeBO> listBO = dao.getEmps();
		//convert listBO to listDTO
		List<EmployeeDTO> listDTO = new ArrayList<>();
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto,"sal");
			dto.setSal(Math.round(bo.getSal()));
			dto.setSno(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
