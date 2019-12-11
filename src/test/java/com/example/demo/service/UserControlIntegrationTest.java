package com.example.demo.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControlIntegrationTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private UserService service;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testCreateUser() throws JsonProcessingException, Exception {
		User user1 = new User("J","H");
		User user2 = new User("J", "H");
		user2.setAccNo("a00000000");
		user2.setId(1L);
		user2.setPrize(0);
		
		Mockito.when(this.service.createUser(user1)).thenReturn(user2);
		
		this.mock.perform(
				request(HttpMethod.POST, "/createUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(user1))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
