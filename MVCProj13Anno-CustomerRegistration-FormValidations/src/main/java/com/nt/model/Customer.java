package com.nt.model;

import lombok.Data;

@Data
public class Customer {
	
	//private Integer cno;
	private String name;
	private String address;
	private Float billAmount;
	private String vflag = "no";

}
