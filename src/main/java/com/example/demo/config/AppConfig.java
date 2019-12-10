package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.AccountNumberGeneratorService;
import com.example.demo.util.NumberGenerator;

@Configuration
public class AppConfig {
	
	@Bean
	public AccountNumberGeneratorService numGen() {
		return new AccountNumberGeneratorService(new NumberGenerator());
		
	}

}
