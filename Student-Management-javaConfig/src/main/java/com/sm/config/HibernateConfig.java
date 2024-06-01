package com.sm.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.sm.api.Student;

import jakarta.servlet.ServletContextEvent;



//to make this class to singleton : means only one sessionFactory object should be created , 
//because it is heavy object
//while creating sessionFactory instance wrap it with try catch block
public class HibernateConfig {
	private static final Logger log = LogManager.getLogger(HibernateConfig.class.getName());
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		log.info("HibernateConfig config called");
		try {
			if (sessionFactory == null) {
				
				// create a configuration
				// its a class helps to bootstrap the hibernate
				// help us to configure the dataSource.
				// Bootstrapping the hibernate app with these configuration
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				configuration.addAnnotatedClass(Student.class);
				
				// create session factory
				// to create session factory we need configuration
				// to create dataSource we need sessionFactory
				sessionFactory = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("session factory object is not created");
		}

		return sessionFactory;
		
	}
	
	public void contextDestroyed(ServletContextEvent event) {
        sessionFactory.close();
    }

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	
}
