package com.bhaskar.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhaskar.employee.impl.EmployeeServiceImpl;
import com.bhaskar.employee.model.Employee;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {
    
    @Autowired
    private EmployeeServiceImpl serviceImpl;

    @PostMapping(value = "/employees")
    public Employee saveEmployee(@RequestBody Employee employee){

        return serviceImpl.creatEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployees(){
        return serviceImpl.list();
    }

    @PutMapping(value = "/employees/{id}")
    public Employee updateEmployee(@PathVariable("id")Long id, @RequestBody Employee employee){

        return serviceImpl.updatEmployee(id, employee);
    }

    @GetMapping(value = "/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id")Long id){

        return serviceImpl.getEmployeeById(id);
    }

    @DeleteMapping(value = "/employees/{id}")
    public String deleteEmployee(@PathVariable("id")Long id){

        serviceImpl.deleteEmployeeById(id);
        return "Employee Deleted from DB successfully : " +id;
    }


}
