package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.entity.UserData;

public interface IUserManagementRepository extends CrudRepository<UserData, Integer>,PagingAndSortingRepository<UserData, Integer>
{

}
