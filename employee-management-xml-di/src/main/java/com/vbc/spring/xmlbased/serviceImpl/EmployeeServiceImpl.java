package com.vbc.spring.xmlbased.serviceImpl;

import com.vbc.spring.xmlbased.model.Employee;
import com.vbc.spring.xmlbased.serviceI.EmployeeServiceI;

public class EmployeeServiceImpl implements EmployeeServiceI {
    @Override
    public void showEmployeeDetails(Employee employee) {
        System.out.println("Employee Details: ");
        System.out.println(employee);
    }
}

