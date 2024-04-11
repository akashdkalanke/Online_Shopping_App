package com.yash.ecommerceonlineshoppingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String phoneNo;
	private String role;
	private String street;
	private String city;
	private int pincode;

}
