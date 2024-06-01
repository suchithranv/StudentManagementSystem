package com.sm.config;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	private static final Logger log = LogManager.getLogger(MailConfig.class.getName());
	    @Bean
	    public JavaMailSender javaMailSender() {
	    	log.info("Mail config called");
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com"); // set the SMTP server host
	        mailSender.setPort(587); // set the SMTP server port
	        mailSender.setUsername("suchitranv5@gmail.com"); // set the SMTP server username
	        mailSender.setPassword("jzixqzxxayqzchbg"); // set the SMTP server password

	        Properties props = mailSender.getJavaMailProperties();
	       // props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.starttls.required", "true");
	        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true"); // enable debug mode to log SMTP server interactions

	        return mailSender;
	    }

}
