package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Student;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.StudentRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    SubjectRepository subjectRepository;
    StudentRepository studentRepository;

    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public Subject getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }


    public List<Subject> createNewSubject(Subject subject) {

        List<Subject> subjectList = subjectRepository.findAll();
        Optional<Subject> existingSubject = subjectRepository.findBySubjectName(subject.getSubjectName());

        if (existingSubject.isEmpty()) {
            subjectRepository.save(subject);
            subjectList = subjectRepository.findAll();
            subject.setStudentList(new ArrayList<>());
            return subjectList;
        }
        return subjectList;
    }

    public Subject assignStudentsToSubjects(Long subjectId, Long studentId) {

        Optional<Subject> subject = subjectRepository.findById(subjectId);
        Optional<Student> student = studentRepository.findById(studentId);

        return subject.flatMap(subject1 ->
                student.map(student1 -> {
                    subject1.getStudentList().add(student1);
                    subjectRepository.save(subject1);
                    student1.getStudentSubjects().add(subject1);
                    return subject1;
                })).orElse(null);

    }
}
