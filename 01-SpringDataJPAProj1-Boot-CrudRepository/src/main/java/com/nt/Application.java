package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		//get service object
		IEmployeeMgmtService service = ctx.getBean("empService",EmployeeMgmtServiceImpl.class);
		
		//invoke method
		EmployeeDTO dto = new EmployeeDTO("Praveen", "Ramachandrapuram", 15000.0f);
		System.out.println("Employee Registered with ID::"+service.register(dto));
		
		//close Container
		((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
