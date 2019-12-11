package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.persistance.entities.User;

import com.example.demo.rest.UserController;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

	@Autowired	
	private MockMvc mock; 		
	
	@MockBean
	private UserService service;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testCreateUser() throws JsonProcessingException, Exception {	
		User u1 = new User("Alwin", "Thomas");	
		User u2 = new User("Alwin", "Thomas"); 
		u2.setId(1L);		
		u2.setAccNo("8");
		u2.setPrize(50);
		
		Mockito.when(this.service.createUser(u1)).thenReturn(u2);	
		
		this.mock.perform(	
				request(HttpMethod.POST, "/createUser")	
				.contentType(MediaType.APPLICATION_JSON)	
				.content(this.mapper.writeValueAsString(u1))	
				.accept(MediaType.APPLICATION_JSON))	
				.andExpect(status().isOk()); 
	
}
}
