package com.example.springdatajpamappings.springdatajpamappings.controllers.shcool_management_controllers;

import com.example.springdatajpamappings.springdatajpamappings.dto.StudentAdmissionDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Student;
import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.AdmissionRecordService;
import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    StudentService studentService;
    AdmissionRecordService admissionRecordService;

    public StudentController(StudentService studentService, AdmissionRecordService admissionRecordService) {
        this.studentService = studentService;
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public Student createNewStudent(@RequestBody StudentAdmissionDto studentAdmissionDto) {
        return studentService.createNewStudent(studentAdmissionDto);
    }

    @PutMapping(path = "/{studentId}/professors/{professorId}")
    public Student assignProfessorToStudents(@PathVariable Long studentId, @PathVariable Long professorId) {
        return studentService.assignStudentToProfessor(studentId, professorId);
    }

}
