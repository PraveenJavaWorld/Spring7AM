package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@RequestMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/showEmps")
	public String getEmps(Map<String,Object> map) {
		//use service
		List<EmployeeDTO> listDTO = service.fetchEmps();
		//keep results in Model Attributes
		map.put("listDTO", listDTO);
		//return lvn
		return "list_Emps";
	}

}
