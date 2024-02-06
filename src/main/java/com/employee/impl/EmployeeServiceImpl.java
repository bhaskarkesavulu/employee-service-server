package com.employee.impl;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    @Override
    public Employee saveEmployee(Employee employee) {

        Employee employee1 = repository.save(employee);
        log.info("Saved Object is {}", employee1);
        return employee1;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Employee employee1 = repository.save(employee);
        log.info("Updated Object is : {}", employee1);
        return employee1;
    }

    @Override
    public List<Employee> getEmployees() {

        List<Employee> list = repository.findAll();
        log.info("List of Employees is : {}", list);
        return list;
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        Optional<Employee> employeeById = repository.findById(employeeId);
        log.info("Employee by Id is : {}", employeeById);
        return employeeById;
    }

    @Override
    public String deleteEmployeeById(Long employeeId) {
        repository.deleteById(employeeId);
        return "Delete Employee is :  " + employeeId;
    }
}
