package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.example.demo.persistance.User;
import com.example.demo.persistance.UserRepo;
import com.example.demo.persistance.UserService;

@SpringBootApplication
public class AccountAppApplication {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(AccountAppApplication.class, args);
		UserRepo ur = ac.getBean(UserRepo.class);
		ur.save(new User("Alwin", "Thomas", "id"));
		UserService us = ac.getBean(UserService.class);
		System.out.println(us.readUsers());

		
		

	}

}
