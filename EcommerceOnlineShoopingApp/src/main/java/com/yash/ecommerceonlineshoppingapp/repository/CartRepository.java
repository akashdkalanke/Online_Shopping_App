package com.yash.ecommerceonlineshoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ecommerceonlineshoppingapp.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
