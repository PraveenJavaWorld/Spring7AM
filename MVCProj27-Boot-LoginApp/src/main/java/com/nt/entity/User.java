package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERS_LIST")
@Data
public class User {
	@Id
	private String username;
	private String password;

}
