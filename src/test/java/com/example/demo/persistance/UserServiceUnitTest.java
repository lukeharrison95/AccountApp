package com.example.demo.persistance;

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
		List<User> accounts = new ArrayList<>();
		accounts.add(new User("J", "H", "3"));
		Mockito
			.when(repo.findAll())
			.thenReturn(accounts);
		assertTrue("Returned no users", this.service.readUsers().size() > 0);

		Mockito.verify(repo, times(1)).findAll();
	}
}