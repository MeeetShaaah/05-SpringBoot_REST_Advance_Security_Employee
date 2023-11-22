package com.luv2code.employee_cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.employee_cruddemo.entity.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{
    
}
