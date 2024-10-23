package com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
