package com.luv2code.employee_cruddemo.service;

import java.util.List;

import com.luv2code.employee_cruddemo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theID);
    Employee save(Employee theEmployee);
    void deletebyId(int theId);
}
