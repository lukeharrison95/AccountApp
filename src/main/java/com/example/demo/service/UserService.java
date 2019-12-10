package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.entities.User;
import com.example.demo.persistance.repository.UserRepo;
import com.example.demo.util.PrizeGenerator;
import com.example.demo.util.exceptions.UserNotFoundException;

@Service
public class UserService {
	
	private UserRepo repo;

	public User createUser(User user) {
		user.setAccNo(this.numGen.genNumber());
		user.setPrize(prizeGen.prizeGen(user.getAccNo()));
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
	
	public User updateUser(User user, Long id) {
		User toUpdate = this.repo.getOne(id);
		toUpdate.setFirstName(user.getFirstName());
		toUpdate.setLastName(user.getLastName());
		toUpdate.setAccNo(this.numGen.genNumber());
		return this.repo.save(toUpdate);
	}
	
	public void deleteUser(Long id) {
		this.repo.deleteById(id);
	}
	
	@Autowired
	private UserService(UserRepo repo) {
		this.repo = repo;
	}
	@Autowired
	private AccountNumberGeneratorService numGen;
	
	@Autowired
	private PrizeGenerator prizeGen;

}