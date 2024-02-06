package com.employee.service;

import com.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public List<Employee> getEmployees();

    public Optional<Employee> getEmployeeById(Long employeeId);

    public String deleteEmployeeById(Long employeeId);
}
