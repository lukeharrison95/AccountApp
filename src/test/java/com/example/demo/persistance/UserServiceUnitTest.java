package com.example.demo.persistance;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.persistance.User;
import com.example.demo.persistance.UserRepo;
import com.example.demo.persistance.UserService;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest {
	
	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepo repo;
	
	@Test
	public void getAllUsersTest() {
		Mockito
			.when(repo.findAll())
			.thenReturn(new ArrayList<User>());
		this.service.readUsers();		
	}
}