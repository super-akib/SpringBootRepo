package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bindings.EmployeeInfo;
import com.demo.entity.EmployeeInfoEntity;
import com.demo.repository.IEmployeeInfoRepository;
@Service
public class EmployeeManagementServiceImpl implements IEmployeeServiceManagement {
    
	@Autowired
	private IEmployeeInfoRepository  employeeRepository;
	
	private EmployeeInfoEntity  employeeEntity = new EmployeeInfoEntity();
	@Override
	public String saveEmployeeData(EmployeeInfo employee) 
	{ 
		BeanUtils.copyProperties(employee, employeeEntity);
		
		Integer employeeId = employeeRepository.save(employeeEntity).getEmployeeId();
		return "Employee sucessfully saved there id is::"+employeeId;
	}
	@Override
	public List<EmployeeInfo> findAllEmployee() {
		
		return 	 employeeRepository.findAll().stream()
			    .map(entity -> {
			        EmployeeInfo emp = new EmployeeInfo();
			        BeanUtils.copyProperties(entity, emp);
			        return emp;
			    }).collect(Collectors.toList());
	}

}
