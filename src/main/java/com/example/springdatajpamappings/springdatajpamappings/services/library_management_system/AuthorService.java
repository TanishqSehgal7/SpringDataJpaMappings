package com.example.springdatajpamappings.springdatajpamappings.services.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Author;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.AuthorRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(Author author) {
        Optional<Author> existingAuthor = authorRepository.findById(author.getId());
        if(!existingAuthor.isPresent()) {
            return authorRepository.save(author);
        } else {
            return null;
        }
    }
}
