package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	//home page
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	//list of emps
	@GetMapping("/list")
	public String showEmps(Map<String,Object> map) {
		//use service
		Iterable<Employee> it = service.fetchAllEmps();
		//add Iterable to map attribute
		map.put("list", it);
		//return lvn
		return "show_emps";
	}
	
	//form to add emps
	@GetMapping("/empForm")
	public String empRegisterForm(@ModelAttribute("emp") Employee emp) {		
		//keep initial data
		emp.setSalary(40000.0f);
		//return lvn
		return "register_emp";
	}
	
	//to add emp
	@PostMapping("/addEmp")
	public String insertEmp(RedirectAttributes attr,@ModelAttribute("emp") Employee emp) {
		//use service
		String result = service.insertEmployee(emp);
		attr.addFlashAttribute("msg", result);
		return "redirect:list";
	}
	
	//form to edit emp
	@GetMapping("/edit")
	public String empEditForm(@RequestParam("id") int id,@ModelAttribute("empEditform") Employee emp) {
		//use service
		Employee emp1 = service.fetchEmployeeById(id);
		//copy existing details of employee based on id to form(Data Binding)
		BeanUtils.copyProperties(emp1, emp);
		//return lvn
		return "edit_emp";
	}
	
	//to edit emp
	@PostMapping("/editEmp")
	public String empEdit(RedirectAttributes attr,@ModelAttribute("empEditform") Employee emp) {
		//use service
		String result = service.updateEmployee(emp);
		attr.addFlashAttribute("editMsg", result);
		return "redirect:list";
	}
	
	//to delete emp
	@GetMapping("/delete")
	public String deleteEmp(RedirectAttributes attr,@RequestParam("id") int id) {
		//use service
		service.deleteEmployeeById(id);
		attr.addFlashAttribute("deleteMsg", "Employee of ID "+id+ " is Deleted");
		return "redirect:list";
	}

}
