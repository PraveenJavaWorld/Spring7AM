package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/form")
	public String showForm(@ModelAttribute("stud") Student st) {
		//keep initial data in Model class obj
		st.setAddress("RCPM");
		//return lvn
		return "formPage";
	}
	
	@PostMapping("/save")
	public String saveStudent(Map<String,Object> map,@ModelAttribute("stud") Student st) {
		System.out.println(st);
		//make form data as model attribute
		map.put("formData", st);
		//return lvn
		return "result";
	}

}
