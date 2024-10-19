package com.example.springdatajpamappings.springdatajpamappings.services;

import com.example.springdatajpamappings.springdatajpamappings.entities.EmployeeEntity;
import com.example.springdatajpamappings.springdatajpamappings.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
