package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.dto.ProfessorSubjectDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Professor;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.ProfessorRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    ProfessorRepository professorRepository;
    SubjectRepository subjectRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public Professor getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null)   ;
    }

    public Professor createNewProfessorForExistingSubject(ProfessorSubjectDto professorSubjectDto) {

        Optional<Professor> existingProfessor = professorRepository.findByProfessorName(professorSubjectDto.getProfessorName());
        List<Subject> subjectList = subjectRepository.findAllById(professorSubjectDto.getSubjectIds());

        if(existingProfessor.isPresent()) {
            Professor foundProfessor = existingProfessor.get();
            for(Subject subject: subjectList) {
                for(Long id : professorSubjectDto.getSubjectIds()) {
                    if(subjectRepository.existsById(id)) {
                        subject.setProfessor(foundProfessor);
//                        foundProfessor.getSubjects().add(subject);
                    }
                }
            }
            professorRepository.save(foundProfessor);
            return foundProfessor;
        } else {
            Professor professor = new Professor();
            professor.setProfessorName(professorSubjectDto.getProfessorName());
            for(Subject subject: subjectList) {
                for(Long id : professorSubjectDto.getSubjectIds()) {
                    if(subjectRepository.existsById(id)) {
                        subject.setProfessor(professor);
//                        professor.getSubjects().add(subject);
                    }
                }
            }
            professorRepository.save(professor);
            return professor;
        }
    }

}
