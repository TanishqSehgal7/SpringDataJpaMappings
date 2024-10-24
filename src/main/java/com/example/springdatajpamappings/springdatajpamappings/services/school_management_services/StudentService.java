package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.dto.StudentAdmissionDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.AdmissionRecord;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Student;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.AdmissionRecordRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;
    AdmissionRecordRepository admissionRecordRepository;

    public StudentService(StudentRepository studentRepository, AdmissionRecordRepository admissionRecordRepository) {
        this.studentRepository = studentRepository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public Student createNewStudent(StudentAdmissionDto studentAdmissionDto) {

        AdmissionRecord admissionRecord = new AdmissionRecord();

        Optional<Student> existingStudent = studentRepository.findByStudentName(studentAdmissionDto.getStudentName());

        if(existingStudent.isPresent()) {
            admissionRecord.setFees(studentAdmissionDto.getFees());
            admissionRecord.setStudentAdmissionRecord(existingStudent.orElse(null));
            admissionRecordRepository.save(admissionRecord);
        } else {
            Student student = new Student();
            student.setStudentName(studentAdmissionDto.getStudentName());
            studentRepository.save(student);

            admissionRecord.setFees(studentAdmissionDto.getFees());
            admissionRecord.setStudentAdmissionRecord(student);
            admissionRecordRepository.save(admissionRecord);
            return student;
        }

        return existingStudent.orElse(null);
    }
}
