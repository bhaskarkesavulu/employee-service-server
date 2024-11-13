package com.bhaskar.employee.service;

import java.util.List;

import com.bhaskar.employee.model.Employee;

public interface EmployeeService {
    
    public Employee creatEmployee(Employee employee);
    public Employee updatEmployee(Long id, Employee employee);
    public Employee getEmployeeById(Long id);
    public List<Employee> list();
    public Employee deleteEmployeeById(Long id);
}
