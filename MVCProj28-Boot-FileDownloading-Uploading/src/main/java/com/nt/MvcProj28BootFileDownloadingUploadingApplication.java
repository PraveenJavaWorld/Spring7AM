package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class MvcProj28BootFileDownloadingUploadingApplication {

	@Bean
	public CommonsMultipartResolver createResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MvcProj28BootFileDownloadingUploadingApplication.class, args);
	}

}
