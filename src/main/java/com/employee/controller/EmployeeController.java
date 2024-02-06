package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @Operation(summary = "Create an employee", description = "Employee Created")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Created")
    })
    @PostMapping(value = "/save")
    public Employee saveEmployee(@RequestBody Employee employee){

        return service.saveEmployee(employee);
    }

    @Operation(summary = "Update an employee", description = "Employee Updated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Updated")
    })
    @PutMapping(value = "/update")
    public Employee updateEmployee(@RequestBody Employee employee){

        return service.saveEmployee(employee);
    }

    @Operation(summary = "Get a Employee by id", description = "Returns a Employee as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The Employee was not found")
    })
    @GetMapping
    public Optional<Employee> getEmployeeById(@RequestParam Long employeeId){

        return service.getEmployeeById(employeeId);
    }

    @Operation(summary = "List of employees", description = "Employee List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Fetched List")
    })
    @GetMapping(value = "/list")
    public List<Employee> employeeList(){

        return service.getEmployees();
    }

    @Operation(summary = "Delete an employee", description = "Employee Deleted")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Deleted")
    })
    @DeleteMapping
    public String deleteEmployeeById(@RequestParam Long employeeId){

        service.deleteEmployeeById(employeeId);
        return "Delete Employee is : {}" + employeeId;
    }
}
