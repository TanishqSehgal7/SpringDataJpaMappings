package com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByBookName(String bookName);
}