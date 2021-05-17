package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDTO;

@Controller
public class EmployeeController {
	
	@RequestMapping("/list")
	public String listEmps(Map<String,Object> map) {
		//create model data
		map.put("eid", 1001);
		map.put("ename", "Praveen");
		map.put("job", "Java Developer");
		map.put("salary", 40000.0);
		
		//Collections data
		List<String> list = List.of("Orange","Mango","Grapes"); // Java 9
		Set<Long> set = Set.of(123456789L,987654321L,963852741L);
		Map<String,Integer> marksMap = Map.of("Maths",100,"Physics",95,"Chemistry",97);
		// Arrays Data
		String favColors[] = new String[] {"Yellow","Orange","Blue"};
		
		map.put("fruits", list);
		map.put("numbers", set);
		map.put("marks", marksMap);
		map.put("colors", favColors);
		
		//Model Obj Data
		EmployeeDTO dto = new EmployeeDTO(1002, "Rocky", "UI Developer", 30000.0);
		
		map.put("empDTO", dto);
		
		//List of DTO Obj
		List<EmployeeDTO> listDTO = List.of(new EmployeeDTO(1003, "Praveen", ".Net Developer", 35000.0),
											new EmployeeDTO(1004, "Rocky", "Python Developer", 45000.0),
											new EmployeeDTO(1005, "Praveen", "Full Stack Developer", 90000.0)); 
		
		
		map.put("empList", listDTO);
		
		
		//return lvn
		return "show";
	}

}
