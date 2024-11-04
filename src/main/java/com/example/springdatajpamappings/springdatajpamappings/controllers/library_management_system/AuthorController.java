package com.example.springdatajpamappings.springdatajpamappings.controllers.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Author;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.AuthorRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.BookRepository;
import com.example.springdatajpamappings.springdatajpamappings.services.library_management_system.AuthorService;
import com.example.springdatajpamappings.springdatajpamappings.services.library_management_system.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    AuthorService authorService;
    BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

}
