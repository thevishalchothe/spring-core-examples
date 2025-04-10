package com.vbc.spring.xmlbased.model;

import lombok.Data;

@Data
public class Employee {
    private int empId;
    private String empName;
    private double salary;
    private Department department;
}
