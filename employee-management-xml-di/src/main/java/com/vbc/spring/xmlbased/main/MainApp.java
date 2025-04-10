package com.vbc.spring.xmlbased.main;

import com.vbc.spring.xmlbased.serviceI.EmployeeServiceI;
import com.vbc.spring.xmlbased.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Employee employee = context.getBean("employee", Employee.class);
        EmployeeServiceI service = context.getBean("employeeService", EmployeeServiceI.class);

        service.showEmployeeDetails(employee);
    }
}
