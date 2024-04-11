package com.yash.ecommerceonlineshoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ecommerceonlineshoppingapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmailIdAndPasswordAndRole(String emailId,String password,String role);

}
