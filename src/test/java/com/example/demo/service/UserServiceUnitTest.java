package com.example.demo.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.persistance.entities.User;
import com.example.demo.rest.UserController;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest {

	@InjectMocks
	private UserController controller;

	@Mock
	private UserService service;

	@Test
	public void getAllUsersTest() {
		List<User> accounts = new ArrayList<>();
		accounts.add(new User("J", "H"));
		Mockito.when(service.readUsers()).thenReturn(accounts);
		assertTrue("Returned no users", this.controller.getAll().size() > 0);

		Mockito.verify(service, times(1)).readUsers();
	}
}