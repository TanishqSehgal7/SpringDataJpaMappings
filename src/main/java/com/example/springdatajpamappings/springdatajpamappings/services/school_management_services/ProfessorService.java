package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.dto.ProfessorSubjectDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Professor;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.ProfessorRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.StudentRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.SubjectRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    ProfessorRepository professorRepository;
    SubjectRepository subjectRepository;
    StudentRepository studentRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public Professor getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null)   ;
    }

    public Professor createNewProfessorForExistingSubject(ProfessorSubjectDto professorSubjectDto) {

        // Check if professor exists
        Optional<Professor> existingProfessor = professorRepository.findByProfessorName(professorSubjectDto.getProfessorName());

        // Fetch subjects by their IDs
        List<Subject> subjectList = subjectRepository.findAllById(professorSubjectDto.getSubjectIds());

        Professor professor;

        if (existingProfessor.isPresent()) {
            // Use the existing professor
            professor = existingProfessor.get();
        } else {
            // Create a new professor
            professor = new Professor();
            professor.setProfessorName(professorSubjectDto.getProfessorName());
            professor.setSubjects(new ArrayList<>()); // Ensure subjects list is initialized
        }

        // Assign subjects to the professor
        for (Subject subject : subjectList) {
            if (subject.getProfessor() == null) { // Ensure the subject is not already assigned
                subject.setProfessor(professor);
                professor.getSubjects().add(subject);
            }
        }

        // Save the professor with the updated subjects
        return professorRepository.save(professor);
    }
}
