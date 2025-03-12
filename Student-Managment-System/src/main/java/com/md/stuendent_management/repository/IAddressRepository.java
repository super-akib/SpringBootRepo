package com.md.stuendent_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.md.stuendent_management.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
