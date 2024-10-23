package com.example.springdatajpamappings.springdatajpamappings.controllers.shcool_management_controllers;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Student;
import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public Student createNewStudent(@RequestBody Student student) {
        return studentService.createNewStudent(student);
    }

}
