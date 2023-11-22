//package com.luv2code.employee_cruddemo.dao;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.luv2code.employee_cruddemo.entity.Employee;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//
//@Repository
//public class EmployeeDaoImpli implements EmployeeDao{
//
//    private EntityManager entityManager;
//
//    public EmployeeDaoImpli(EntityManager theEntityManager){
//        this.entityManager = theEntityManager;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        //create the query
//        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
//
//        //execute the query and get the result
//        List<Employee> employees = theQuery.getResultList();
//
//        //return the result to the end-user
//        return employees;
//    }
//
//    @Override
//    public Employee findById(int theID) {
//        //create query to get employee by id
//        Employee theEmployee = entityManager.find(Employee.class, theID);
//
//        //return employee
//        return theEmployee;
//    }
//
//    @Override
//    public Employee save(Employee theEmployee) {
//        // create employee to add new employee or update employee
//        Employee dbEmployee = entityManager.merge(theEmployee);
//
//        // return employee
//        return dbEmployee;
//    }
//
//    @Override
//    public void deletebyId(int theId) {
//        // find by id
//        Employee theEmployee = entityManager.find(Employee.class, theId);
//
//        // remove employee
//         entityManager.remove(theEmployee);
//    }
//
//}
