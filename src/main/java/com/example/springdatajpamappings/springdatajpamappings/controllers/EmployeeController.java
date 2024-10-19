package com.example.springdatajpamappings.springdatajpamappings.controllers;

import com.example.springdatajpamappings.springdatajpamappings.entities.EmployeeEntity;
import com.example.springdatajpamappings.springdatajpamappings.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.createNewEmployee(employee);
    }

}
