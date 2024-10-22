package com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories;

import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
