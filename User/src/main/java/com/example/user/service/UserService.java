package com.example.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.Repository.UserRepository;
import com.example.user.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
    List<User> ui = new ArrayList<>();
	
	
	
	
	public List<User> getUser() {
		return (List<User>) repo.findAll();
	}
	
	public User getuserById(int userId)
	{
		return repo.findById(userId)
		.orElseThrow(()->new RuntimeException("user not found"));
		
	}
	
	public User getuserByname(String userName)
	{
		return repo.findByuserName(userName);
	}
	
	public User getUserbyAddress(String address)
	{
		return repo.findByaddress(address);
	}
	public User insertUser(User usr) {
		return repo.save(usr);
	}
	
	public User getunameandaddr(String UserName,String address) {
		return repo.findUseraddrandUname(UserName,address);
	}
	public User  updateUser( int userId,User usr)
	{
		User existing =  this.getuserById(userId);
		
		if(usr.getUserName()!=null)
		{
			existing.setUserName(usr.getUserName());
		}
		if(usr.getAddress()!=null)
		{
			existing.setAddress(usr.getAddress());
			
		}
		return repo.save(existing);
	}
   
	public String deleteUser(int userId)
	{
		
		repo.deleteById(userId);
		return "User delete";

	}
	

}
