package com.betinsk.mc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.betinsk.mc.services.EmailService;
import com.betinsk.mc.services.SmtpEmailService;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}


	
}
