package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/form")
	public String showForm() {
		return "formPage";
	}
	
	@RequestMapping("/save")
	public String saveStudent(Map<String,Object> map,@ModelAttribute("stud") Student st) {
		System.out.println(st);
		//make form data as model attribute
		map.put("formData", st);
		//return lvn
		return "result";
	}

}
