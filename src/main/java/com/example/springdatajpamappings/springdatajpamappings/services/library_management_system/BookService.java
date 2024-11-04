package com.example.springdatajpamappings.springdatajpamappings.services.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.AuthorRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.BookRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createNewBook(Book book) {

//        Optional<Book> existingBook = bookRepository.findById(book.getId());
//        if (!existingBook.isPresent()) {
            return bookRepository.save(book);
//        } else {
//            return null;
//        }
    }
}
