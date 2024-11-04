package com.example.springdatajpamappings.springdatajpamappings.controllers.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import com.example.springdatajpamappings.springdatajpamappings.services.library_management_system.AuthorService;
import com.example.springdatajpamappings.springdatajpamappings.services.library_management_system.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    BookService bookService;
    AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping
    public Book createNewBook(@RequestBody Book book) {
        return bookService.createNewBook(book);
    }

}
