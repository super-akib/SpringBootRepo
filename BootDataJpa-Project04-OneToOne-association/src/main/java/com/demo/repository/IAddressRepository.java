package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> 
{
 
}
