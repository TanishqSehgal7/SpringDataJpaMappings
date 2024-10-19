package com.example.springdatajpamappings.springdatajpamappings.services;

import com.example.springdatajpamappings.springdatajpamappings.entities.DepartmentEntity;
import com.example.springdatajpamappings.springdatajpamappings.repositories.DepartmentRepository;

public class DepartmentService {
    private final DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
