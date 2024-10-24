package com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByStudentName(String name);
}
