package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AccountAppApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void accountNumberGenerationTest() {
		AccountNumber accNo = new AccountNumber();
		assertEquals(expected, actual);
	}

}
