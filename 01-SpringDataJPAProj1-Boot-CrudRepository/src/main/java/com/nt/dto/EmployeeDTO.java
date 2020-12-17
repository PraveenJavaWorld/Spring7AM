package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;

@Data
public class EmployeeDTO implements Serializable {
	
	private Integer eid;
	@NonNull
	private String ename;
	@NonNull
	private String eaddress;
	@NonNull
	private Float salary;

}
