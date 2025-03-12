package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer> ,PagingAndSortingRepository<User, Integer>
{

}
