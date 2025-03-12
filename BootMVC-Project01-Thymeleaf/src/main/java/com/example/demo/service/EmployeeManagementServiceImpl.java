package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	
	private EmployeeRepository  employeeRepository;
	
    //Constructor injection 
	public EmployeeManagementServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Page<Employee> showEmployeesByPagination(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	@Override
	public String registerEmployee(Employee employee)
	{
		return "Employee register sucessfully by empNo="+employeeRepository.save(employee).getEmpNo();
	}
 
	@Override
	public String editEmployeeById(Employee employee) {
		
		Optional<Employee> findById = employeeRepository.findById(employee.getEmpNo());
		
		if(findById.isEmpty())
		{
			return"Invalid id";
		}
		else
		{
			return employeeRepository.save(employee).getEmpNo()+" employee edit sucessfully";			
		}
	}
}
