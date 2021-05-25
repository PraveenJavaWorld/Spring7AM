package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable{
	
	private Integer sno;
	private Integer empno;
	private String ename;
	private String job;
	private Integer sal;

}
