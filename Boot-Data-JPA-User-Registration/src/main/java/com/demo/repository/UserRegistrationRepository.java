package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.User;

public interface UserRegistrationRepository extends JpaRepository<User, Integer> {

}
