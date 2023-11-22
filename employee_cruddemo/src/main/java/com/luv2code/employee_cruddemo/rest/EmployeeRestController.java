package com.luv2code.employee_cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.employee_cruddemo.entity.Employee;
import com.luv2code.employee_cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    // inject service to the rest so it works into link from database to dao to service to rest...
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }
    
    // mapping to find all the employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping to search employee by ID
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee Not Found" + employeeId);
        }
        
        return theEmployee;
    }

    // add mapping for Post/employees- to add employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }   

    // add mapping for Put/employees/{employeeId} to update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    // add mapping for Delete/employee/{employeeId} - delete the employee 
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee Not Found" + employeeId);
        }

        employeeService.deletebyId(employeeId);

        return "Employee is deleted with id - " + employeeId;
    }
}