package com.example.demo.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private UserRepo repo;

	public User createUser(User user) {
		return this.repo.save(user);
	}
	
	public List<User> readUsers(){
		return this.repo.findAll();
	}
	
	public User findUserByID(Long id) throws UserNotFoundException {
		return this.repo.findById(id).orElseThrow(() -> new UserNotFoundException());
	}
	
	public List<User> findUserByLastName(String lastName) {
		return this.repo.findByLastName(lastName);
	}
	
	public List<User> findUserByFirstName(String firstName) {
		return this.repo.findByFirstName(firstName);
	}
	
	public void updateUser(User user, Long id) {
		User toUpdate = this.repo.getOne(id);
		toUpdate.setFirstName(user.getFirstName());
		toUpdate.setLastName(user.getLastName());
		toUpdate.setAccNo(user.getAccNo());
		this.repo.save(toUpdate);
	}
	
	public void deleteUser(Long id) {
		this.repo.deleteById(id);
	}
	
	@Autowired
	private UserService(UserRepo repo) {
		this.repo = repo;
	}

}