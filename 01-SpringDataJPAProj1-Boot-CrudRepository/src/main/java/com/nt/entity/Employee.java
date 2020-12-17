package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer eid;
	
	@Column(name = "NAME",length = 20)
	private String ename;
	
	@Column(name = "ADDRESS",length = 20)
	private String eaddress;
	
	@Column(name = "SALARY")
	private Float salary;

}
