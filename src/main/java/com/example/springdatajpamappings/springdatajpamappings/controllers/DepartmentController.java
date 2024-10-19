package com.example.springdatajpamappings.springdatajpamappings.controllers;

import com.example.springdatajpamappings.springdatajpamappings.entities.DepartmentEntity;
import com.example.springdatajpamappings.springdatajpamappings.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    public DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity department) {
        return departmentService.createNewDepartment(department);
    }
}