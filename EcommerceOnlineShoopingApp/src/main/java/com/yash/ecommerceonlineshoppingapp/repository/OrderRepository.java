package com.yash.ecommerceonlineshoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ecommerceonlineshoppingapp.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
