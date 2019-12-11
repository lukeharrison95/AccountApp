package com.example.demo.persistance.entities;

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
	
	private double prize;
	
	public User() {
	}	

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
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
	
	public double getPrize() {
		return prize;
	}

	public void setPrize(double d) {
		this.prize = d;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Name= "  + firstName + " " + lastName + "]";
	}


}
