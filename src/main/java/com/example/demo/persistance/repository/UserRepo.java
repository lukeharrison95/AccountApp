package com.example.demo.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistance.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	List<User> findByFirstName(String firstname);
	List<User> findByLastName(String firstname);

}
