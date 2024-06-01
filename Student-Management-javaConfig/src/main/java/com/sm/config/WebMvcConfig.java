package com.sm.config;


//replacement of application-config.xml file
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration                                    // to let spring know that this is a spring bean config file
@ComponentScan(basePackages = { "com.sm" })    // activate component-scan
@EnableWebMvc 
public class WebMvcConfig implements WebMvcConfigurer {
    
	private static final Logger log = LogManager.getLogger(WebMvcConfig.class.getName());
	// setup MVC view resolver
	 
	@Bean //Spring will create object for InternalResourceViewResolver class and put viewResolver object in the container
	public InternalResourceViewResolver viewResolver() {
		log.info("WebMvc config called");
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	
	return viewResolver;
	
	}
	
	//Add support for reading web resources: css, images, js, etc
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		// /resources/css/somthing.css
		// /resources/js/somthing.js
		// /resources/images/somthing.png

	}
	
	
	
	
}
