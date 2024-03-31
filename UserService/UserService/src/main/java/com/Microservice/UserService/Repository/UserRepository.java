package com.Microservice.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.UserService.Entity.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
