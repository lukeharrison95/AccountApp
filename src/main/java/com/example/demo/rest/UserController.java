package com.example.demo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		this.service.deleteUser(id);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@PathParam("id") Long id, @RequestBody User user) {
		return this.service.updateUser(user, id);
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return this.service.createUser(user);
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return this.service.readUsers();
	}
	
}
