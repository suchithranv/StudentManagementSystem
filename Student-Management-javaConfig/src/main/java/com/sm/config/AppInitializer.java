package com.sm.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

//replacement of web.xml file
//When the web application starts, this class does some initial setup.

public class AppInitializer implements WebApplicationInitializer {
    
	private static final Logger log = LogManager.getLogger(AppInitializer.class.getName());
	private String TMP_FOLDER = "C:/Users/Admin/eclipse-workspace/apache-tomcat-10.1.19/photos";
	private int MAX_UPLOAD_SIZE = 10485760;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        
		//creating container object
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		//WebMvcConfig is replacement of application-config.xml file
		appContext.register(WebMvcConfig.class);
        
		//create dispatcher servlet 
		//addServelt() : This method is used to dynamically add a servlet to a servlet context at runtime.
		//goal is to pass appContext object in dispatcher servlet to create container object.
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
        
		log.info("AppIniilizer config called");
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
				TMP_FOLDER, MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 10, MAX_UPLOAD_SIZE / 2);
		dispatcher.setMultipartConfig(multipartConfigElement);
			

	}

}
