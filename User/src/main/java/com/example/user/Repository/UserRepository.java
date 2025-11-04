package com.example.user.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.user.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

	  public User findByuserName(String userName);
	  
	  public User findByaddress(String address);
	  
	  @Query(value="select * from user where userName:uName And address = :addr",nativeQuery=true)
	  public User findUseraddrandUname(@Param(value="userName") String uName, @Param(value="address") String addr);
	  
	  
	  
}
