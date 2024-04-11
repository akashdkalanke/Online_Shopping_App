package com.yash.ecommerceonlineshoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ecommerceonlineshoppingapp.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
