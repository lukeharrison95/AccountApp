package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.persistance.User;
import com.example.demo.persistance.UserRepo;
import com.example.demo.persistance.UserService;

class UserTest {

	@Test
	public void createNewUserTest() {
		ApplicationContext ac= SpringApplication.run(AccountAppApplication.class);
		UserRepo ur = ac.getBean(UserRepo.class);
		ur.save(new User("Alwin", "Thomas", "id"));
		UserService us = ac.getBean(UserService.class);
		System.out.println(us.readUsers());
		}
							
	

}
