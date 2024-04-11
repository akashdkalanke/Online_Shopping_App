package com.yash.ecommerceonlineshoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ecommerceonlineshoppingapp.dto.LoginRequest;
import com.yash.ecommerceonlineshoppingapp.dto.UserRequest;
import com.yash.ecommerceonlineshoppingapp.entity.User;
import com.yash.ecommerceonlineshoppingapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserRequest userRequest){
	String message=	userService.createUser(userRequest);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<>(allUser,HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody LoginRequest loginRequest){
		
		User userLogin = userService.userLogin(loginRequest);
		if(userLogin==null) {
			return new ResponseEntity<String>("Invalid Credential",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<String>("Login Successfull",HttpStatus.OK);
		}
		
	}

}
