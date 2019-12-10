package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.util.NumberGenerator;

@Service
public class AccountNumberGeneratorService {

	private NumberGenerator numGen;		
	
	public AccountNumberGeneratorService(NumberGenerator numGen) {
		this.numGen = numGen;
	}
	
	public String genNumber() {
		return this.numGen.genNumber();
	}

}
