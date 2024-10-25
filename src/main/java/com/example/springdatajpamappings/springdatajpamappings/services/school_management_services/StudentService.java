package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.dto.StudentAdmissionDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.AdmissionRecord;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Professor;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Student;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.AdmissionRecordRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.ProfessorRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;
    AdmissionRecordRepository admissionRecordRepository;
    ProfessorRepository professorRepository;

    public StudentService(StudentRepository studentRepository, AdmissionRecordRepository admissionRecordRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.admissionRecordRepository = admissionRecordRepository;
        this.professorRepository = professorRepository;
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

    public Professor assignStudentToProfessor(Long professorId, Long studentId) {

        Optional<Professor> professor = professorRepository.findById(professorId);
        Optional<Student> student = studentRepository.findById(studentId);

        return professor.flatMap(professor1 ->
                student.map(student1 -> {
                    professor1.getStudents().add(student1);
                    professorRepository.save(professor1);
                    student1.getProfessors().add(professor1);
                    return professor1;
                })).orElse(null);
    }

}
