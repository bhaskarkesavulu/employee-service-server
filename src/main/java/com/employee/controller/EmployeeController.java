package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @PostMapping(value = "/save")
    public Employee saveEmployee(@RequestBody Employee employee){

        return service.saveEmployee(employee);
    }

    @PutMapping(value = "/update")
    public Employee updateEmployee(@RequestBody Employee employee){

        return service.saveEmployee(employee);
    }

    @GetMapping
    public Optional<Employee> getEmployeeById(@RequestParam Long employeeId){

        return service.getEmployeeById(employeeId);
    }

    @GetMapping(value = "/list")
    public List<Employee> employeeList(){

        return service.getEmployees();
    }

    @DeleteMapping
    public String deleteEmployeeById(@RequestParam Long employeeId){

        service.deleteEmployeeById(employeeId);
        return "Delete Employee is : {}" + employeeId;
    }
}
