package com.example.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	
	@Id
	private Integer userId;
	private String userName;
	private String address;
	
	
	
	
	
	//public User(int userId, String userName, String address) {
		//super();
		//this.userId = userId;
		//this.userName = userName;
		//this.address = address;
	//}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
