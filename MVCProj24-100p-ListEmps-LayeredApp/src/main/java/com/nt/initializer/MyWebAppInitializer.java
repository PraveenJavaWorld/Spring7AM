package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class}; //To specify Configuration class of Parent IOC Container
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCConfig.class}; //To specify Configuration class of Child IOC Container
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; //To configure the url pattern
	}

}
