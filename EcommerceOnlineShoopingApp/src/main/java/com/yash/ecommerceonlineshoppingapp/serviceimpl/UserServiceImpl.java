package com.yash.ecommerceonlineshoppingapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ecommerceonlineshoppingapp.dto.LoginRequest;
import com.yash.ecommerceonlineshoppingapp.dto.UserRequest;
import com.yash.ecommerceonlineshoppingapp.entity.Address;
import com.yash.ecommerceonlineshoppingapp.entity.User;
import com.yash.ecommerceonlineshoppingapp.repository.AddressRepository;
import com.yash.ecommerceonlineshoppingapp.repository.UserRepository;
import com.yash.ecommerceonlineshoppingapp.service.UserService;
@Service
public class UserServiceImpl implements  UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	@Override
	public String createUser(UserRequest userRequest) {
		Address address=new Address();
		address.setCity(userRequest.getCity());
		address.setStreet(userRequest.getStreet());
		address.setPincode(userRequest.getPincode());
		
		address = addressRepository.save(address);
		
		User user=new User();
		user.setAddress(address);
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setEmailId(userRequest.getEmailId());
		user.setPassword(userRequest.getPassword());
		user.setPhoneNo(userRequest.getPhoneNo());
		user.setRole(userRequest.getRole());
		
		user = userRepository.save(user);
		
		if(user==null) {
			return "problem facing while saving user";
		}
		else {
			return "User Save Succefullly";
		}
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User userLogin(LoginRequest loginRequest) {
	return 	userRepository.findByEmailIdAndPasswordAndRole(loginRequest.getEmailId(), loginRequest.getPassword(), loginRequest.getRole());
		
	}

	

}
