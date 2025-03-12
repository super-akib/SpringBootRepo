package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Bank;
import com.demo.entity.Employee;
import com.demo.repository.IBankManagementReposotory;
import com.demo.repository.IEmployeeManagementRepository;

@Service
public class BankManagementServiceImpl implements IBankManagementService {
    @Autowired
    private  IBankManagementReposotory  bankReposotory;

    @Autowired
    private IEmployeeManagementRepository employeeRepository;

    @Override
    public String saveBankAndEmployeesRecord(Bank bank) {  
        if (bank == null) {  
            throw new IllegalArgumentException("Bank object cannot be null.");
        } else {    
            Bank savedBank = bankReposotory .save(bank);  // Save the bank first
            List<Employee> employeeList = bank.getEmployeeList();
            
            // Set the bank reference for each employee before saving
            for (Employee employee : employeeList) {
                employee.setBank(savedBank);
            }
            
            employeeRepository.saveAll(employeeList);  // Save all employees
            return "Bank data successfully recorded in the database.";  
        }
    }
}
