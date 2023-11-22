package com.luv2code.employee_cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.luv2code.employee_cruddemo.dao.EmployeeJpaRepository;
import com.luv2code.employee_cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpli implements EmployeeService{

    // ********This code is for JPA API*********

    // private EmployeeDao employeeDao;
    
    // @Autowired
    // public EmployeeServiceImpli(EmployeeDao theEmployeeDao){
    //     this.employeeDao = theEmployeeDao;
    // }

    // @Transactional
    // @Override
    // public List<Employee> findAll(){
    //     return employeeDao.findAll();
    // }

    // @Transactional
    // @Override
    // public Employee findById(int theID) {
    //     return employeeDao.findById(theID);
    // }

    // @Transactional
    // @Override
    // public Employee save(Employee theEmployee) {
    //    return employeeDao.save(theEmployee);
    // }
    
    // @Transactional
    // @Override
    // public void deletebyId(int theId) {
    //     employeeDao.deletebyId(theId);
    // } 


    // *************Moving from JPA Api to Spring Data JPA.....For that, change the EmployeeDao to EmployeeJpaRepository and employeeDao to employeeJpaREpository***************
    
    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    public EmployeeServiceImpli(EmployeeJpaRepository theEmployeeJpaRepository){
        this.employeeJpaRepository = theEmployeeJpaRepository;
    }

    @Override
    public List<Employee> findAll(){
        return employeeJpaRepository.findAll();
    }

    @Override
    public Employee findById(int theID) {
        Optional<Employee> resultOptional = employeeJpaRepository.findById(theID);
        
        Employee theEmployee = null;
        if (resultOptional.isPresent()){
            theEmployee = resultOptional.get();
        }else{
            throw new RuntimeException("Did not find employee id: " + theID);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
       return employeeJpaRepository.save(theEmployee);
    }

    @Override
    public void deletebyId(int theId){
        employeeJpaRepository.deleteById(theId);
    }

}
