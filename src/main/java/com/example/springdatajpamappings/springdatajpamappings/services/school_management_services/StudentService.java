package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Student;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public Student createNewStudent(Student student) {
        return studentRepository.save(student);
    }
}
