package com.Microservice.UserService.Service;

import java.util.List;

import com.Microservice.UserService.Entity.User;

public interface UserService {

	//create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get single user of given userId
	User getUser(String userId);
}
