package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.EmployeeInfoEntity;

public interface IEmployeeInfoRepository extends JpaRepository<EmployeeInfoEntity, Integer> {

}
