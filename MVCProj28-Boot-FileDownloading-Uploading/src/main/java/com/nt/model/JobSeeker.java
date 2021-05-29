package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeeker {
	
	private String name;
	private String qualification;
	private MultipartFile photo;
	private MultipartFile resume;

}
