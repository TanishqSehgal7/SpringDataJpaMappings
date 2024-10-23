package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }


    public Subject createNewSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
