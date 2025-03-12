package com.nit.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.nit.model.Employee;

@Component
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

    public EmployeeItemProcessor() {
        System.out.println("EmployeeItemProcessor.EmployeeItemProcessor()");
    }

    @Override
    public Employee process(Employee item) throws Exception {
        if (item.getSalary() >= 50000.0) {
            double grossSalary = item.getSalary() + (item.getSalary() * 0.5);
            double netSalary = grossSalary - (item.getSalary() * 0.1);  // Example deduction for tax
            
            item.setGrossSalary(grossSalary);
            item.setNetSalary(netSalary);
            
            return item;
        }
        return null;
    }
}
