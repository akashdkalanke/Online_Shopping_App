package com.yash.ecommerceonlineshoppingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	
	private String emailId;
	private String password;
	private String role;

}
