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
import com.example.demo.persistance.repository.UserRepo;

@RunWith(SpringRunner.class)
public class UserServiceUnitTests {

	@InjectMocks
	private UserService service;

	@Mock
	private UserRepo repo;

	@Test
	public void getAllUsersTest() {
		List<User> users = new ArrayList<>();
		users.add(new User("John", "Doe", "c8884456"));
		Mockito.when(repo.findAll()).thenReturn(users);
		assertTrue("Returned no users", this.service.readUsers().size() > 0);

		Mockito.verify(repo, times(1)).findAll();
	}
}
