package com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findBySubjectName(String subjectName);
}
