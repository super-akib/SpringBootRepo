package com.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Bank;
import com.demo.entity.Employee;
import com.demo.service.IBankManagementService;
@Component
public class TestOneToManyBankRunner implements CommandLineRunner {

	@Autowired 
	private IBankManagementService   bankService;
	
	@Override
	public void run(String... args) throws Exception
	{
		  //create Employee class object using Builder
		Employee emmployee1 = Employee.builder().employeeName("Rohit").departmentNumber(14).departmentName("Sales Management").salary(32000.0).build();
		Employee emmployee2 = Employee.builder().employeeName("Raj").departmentNumber(12).departmentName("Account Management").salary(40000.0).build();
		Employee emmployee3 = Employee.builder().employeeName("Kishor").departmentNumber(10).departmentName("Security Management").salary(25000.0).build();
		Employee emmployee4 = Employee.builder().employeeName("Pavan").departmentNumber(12).departmentName("Insurance Management").salary(24500.0).build();
		Employee emmployee5 = Employee.builder().employeeName("Smith").departmentNumber(9).departmentName("Casher").salary(23000.0).build();
		Employee emmployee6 = Employee.builder().employeeName("Shaiker").departmentNumber(1).departmentName("Manager").salary(65000.0).build();
		
		//Create bank class object using builder
		Bank bank1 = Bank.builder().bankName("Union Bank Of India").bankLocation("Ameerpet Hyderabad Telangana 500078.").bankType("Private Bank").numberOfUsers(250000L).numberOfBranches(43).employeeList(List.of(emmployee1,emmployee2,emmployee3,emmployee4,emmployee5,emmployee6)).build();
       
	     //invoke service method save 
		String record = bankService.saveBankAndEmployeesRecord(bank1);	
		System.out.println(record);
	}

}
