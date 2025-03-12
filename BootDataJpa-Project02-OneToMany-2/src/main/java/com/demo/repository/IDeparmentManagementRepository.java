package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Department;

public interface IDeparmentManagementRepository extends JpaRepository<Department, Integer> {

}
