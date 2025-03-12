package com.demo.service;

import java.util.List;

import com.demo.bindings.EmployeeInfo;

public interface IEmployeeServiceManagement
{
   public String saveEmployeeData(EmployeeInfo employee);
   public List<EmployeeInfo> findAllEmployee();
}
