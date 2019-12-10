package com.example.demo.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String accNo;
	
	public User() {
	}	

	public User(String firstName, String lastName, String accNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accNo = accNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Name= "  + firstName + " " + lastName + "]";
	}


}
