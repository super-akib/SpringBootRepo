package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Bank;

public interface IBankManagementReposotory extends JpaRepository<Bank, Integer> {

}
