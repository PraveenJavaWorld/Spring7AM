package com.nt.model;

import java.util.List;

import lombok.Data;

@Data
public class Customer {
	
	//private Integer cno;
	private String name;
	private String address;
	private Float billAmount;
	private String vflag = "no";
	private String gender = "male";
	private String[] hobbies = new String[]{"Playing PUBG","Coding"};
	private String country = "India";
	private List<String> languages = List.of("Telugu","Hindi");

}
