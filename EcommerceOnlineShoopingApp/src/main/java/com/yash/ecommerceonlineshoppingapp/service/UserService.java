package com.yash.ecommerceonlineshoppingapp.service;

import java.util.List;

import com.yash.ecommerceonlineshoppingapp.dto.LoginRequest;
import com.yash.ecommerceonlineshoppingapp.dto.UserRequest;
import com.yash.ecommerceonlineshoppingapp.entity.User;

public interface UserService {
	
String 	createUser(UserRequest userRequest);

List<User> getAllUser();

User userLogin(LoginRequest loginRequest);



}
