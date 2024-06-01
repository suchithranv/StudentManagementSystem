package com.sm.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class MultipartConfig {
	private static final Logger log = LogManager.getLogger(MultipartConfig.class.getName());
	 @Bean
	    public StandardServletMultipartResolver multipartResolver() {
		     log.info("MultipartConfig config called");
	        return new StandardServletMultipartResolver();
	    }

}
