package com.bhaskar.employee.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.employee.model.Employee;
import com.bhaskar.employee.repository.EmployeeRepository;
import com.bhaskar.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee creatEmployee(Employee employee) {
        
        Employee savedEmployee = repository.save(employee);
        LOG.info("Saved Employee in DB is :{}", savedEmployee);
        return savedEmployee;
    }

    @Override
    public Employee updatEmployee(Long id, Employee employee) {
        
        Employee getEmployeeById = repository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found with the id : " + id));
        LOG.info("Get Employee By ID to update : {}", getEmployeeById);
        getEmployeeById.setEmail(employee.getEmail());
        getEmployeeById.setFirstName(employee.getFirstName());
        getEmployeeById.setId(employee.getId());
        getEmployeeById.setLastName(employee.getLastName());
        Employee afterUpdateEmployee = repository.save(getEmployeeById);
        LOG.info("Update Employee is : {}", afterUpdateEmployee);
        return afterUpdateEmployee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        
        Employee getEmployeeById = repository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found with the id : " + id));
        LOG.info("Get Employee By ID : {}", getEmployeeById);
        return getEmployeeById;
    }

    @Override
    public List<Employee> list() {
        
        List<Employee> list = repository.findAll();
        LOG.info("List OF Employees from DB : {}", list);
        return list;
    }

    @Override
    public Employee deleteEmployeeById(Long id) {
        
        Employee deleteEmployeeById = repository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found with the id : " + id));
        LOG.info("Ready to Delete based on Emploiyee ID :{}", deleteEmployeeById);
        repository.deleteById(id);
        return deleteEmployeeById;
    }
    
}
