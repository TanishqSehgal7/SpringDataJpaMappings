package com.example.springdatajpamappings.springdatajpamappings.controllers.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.dto.BookAuthorDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import com.example.springdatajpamappings.springdatajpamappings.services.library_management_system.AuthorService;
import com.example.springdatajpamappings.springdatajpamappings.services.library_management_system.BookService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Book createNewBookWithAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        return bookService.createNewBookWithAuthor(bookAuthorDto);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping(path = "/search")
    public Book findByBookName(@RequestParam(required = true, name = "bookName") String bookName) {
        return bookService.findByBookName(bookName);
    }

    @GetMapping(path = "/publishedAfter")
    public List<Book> findBooksAfterCertainPublishedDate(@RequestParam(required = true, name = "publishedDate")
                                                         String date) {
        return bookService.findBooksAfterCertainPublishedDate(date);
    }

    @GetMapping(path = "/booksByAuthor")
    public List<Book> findAllBooksBySpecificAuthor(@RequestParam(required = true, name = "authorName") String authorName) {
        return bookService.findAllBooksBySpecificAuthor(authorName);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteBookById(@PathVariable Long id) {
        return bookService.deleteBookById(id);
    }

}
