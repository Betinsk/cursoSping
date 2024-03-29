package com.betinsk.mc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.betinsk.mc.services.DbService;
import com.betinsk.mc.services.EmailService;
import com.betinsk.mc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	
	@Autowired
	private DbService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
