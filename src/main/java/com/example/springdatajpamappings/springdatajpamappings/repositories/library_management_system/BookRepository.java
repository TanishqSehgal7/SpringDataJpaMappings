package com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}