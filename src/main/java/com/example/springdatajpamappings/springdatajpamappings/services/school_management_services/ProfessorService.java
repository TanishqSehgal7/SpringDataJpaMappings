package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Professor;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.ProfessorRepository;

public class ProfessorService {

    ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null)   ;
    }

    public Professor createNewProfessor(Professor professor) {
        return professorRepository.save(professor);
    }
}
