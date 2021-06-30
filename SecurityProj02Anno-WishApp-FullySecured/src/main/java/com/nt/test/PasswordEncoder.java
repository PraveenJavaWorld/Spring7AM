package com.nt.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		System.out.println(encoder.encode("1234"));
		System.out.println(encoder.encode("1997"));

	}

}
