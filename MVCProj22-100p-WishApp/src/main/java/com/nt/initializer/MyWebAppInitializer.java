package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		
		//create Parent IOC Container
		AnnotationConfigWebApplicationContext pCtx = new AnnotationConfigWebApplicationContext();
		pCtx.register(RootAppConfig.class);
		
		//create ContextLoaderListener having Parent IOC Container and register with ServletContainer using ServletContext Object
		ContextLoaderListener listener = new ContextLoaderListener(pCtx);
		sc.addListener(listener);
		
		//create Child IOC Container
		AnnotationConfigWebApplicationContext cCtx = new AnnotationConfigWebApplicationContext();
		cCtx.register(WebMVCConfig.class);
		
		//create DispatcherServlet having Parent IOC Container and register with ServletContainer using ServletContext Object
		DispatcherServlet ds = new DispatcherServlet(cCtx);
		ServletRegistration.Dynamic dyna = sc.addServlet("ds", ds);
		dyna.addMapping("/");
		dyna.setLoadOnStartup(2);

	}

}
