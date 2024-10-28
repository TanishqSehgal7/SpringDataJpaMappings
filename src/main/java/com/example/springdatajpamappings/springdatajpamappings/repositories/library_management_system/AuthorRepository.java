package com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
