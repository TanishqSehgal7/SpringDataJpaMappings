package com.example.springdatajpamappings.springdatajpamappings.services.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.dto.BookAuthorDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Author;
import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.AuthorRepository;
import com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createNewBookWithAuthor(BookAuthorDto bookAuthorDto) {

        Optional<Author> existingAuthor = authorRepository
                .findByAuthorName(bookAuthorDto.getAuthorName());

        Optional<Book> existingBook = bookRepository.findByBookName(bookAuthorDto.getBookName());

        Book book = new Book();
        Author author;

        if(existingAuthor.isPresent()) {
            author = existingAuthor.get();
            System.out.println("Existing Author is present");
        } else {
            author = new Author();
            author.setAuthorName(bookAuthorDto.getAuthorName());
            System.out.println("Existing Author is not present");
        }

        if(existingBook.isPresent()) {
            return existingBook.get();
        }

        book.setBookName(bookAuthorDto.getBookName());
        book.setPublishedDate(LocalDate.parse(bookAuthorDto.getPublishedDate()));
        author.getBooks().add(book);

        book.setAuthorOfTheBooks(author);
//        authorRepository.save(author);

        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName).orElse(null);
    }

    public List<Book> findBooksAfterCertainPublishedDate(String date) {

        LocalDate localDate = LocalDate.parse(date);
        List<Book> booksAfterCertainPublishedDate = bookRepository.findByPublishedDateAfter(localDate).orElse(null).stream().collect(Collectors.toList());

        return booksAfterCertainPublishedDate;
    }

    public List<Book> findAllBooksBySpecificAuthor(String authorName) {

        Optional<Author> authorByName = authorRepository.findByAuthorName(authorName);
        Long authorId = 0L;

        if(authorByName.isPresent()) {
            authorId = authorByName.get().getId();
            System.out.println("Author Id is: " + authorId);
            List<Book> allBooksByAuthor = bookRepository.findByAuthorOfTheBooks_Id(authorId);
            return allBooksByAuthor;
        } else {
            return Collections.emptyList();
        }
    }

    public boolean deleteBookById(Long id) {
        Optional<Book> isExistingBook = bookRepository.findById(id);

        if(isExistingBook.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Book updateBookPartialBookDetails(Map<String, Object> updates, Long bookId) {

        Optional<Book> isBookExistingById = bookRepository.findById(bookId);

        Book book = isBookExistingById.get();
        if(isBookExistingById.isPresent()) {
            updates.forEach((field,value) -> {
                Field fieldToUpdate = ReflectionUtils.findRequiredField(Book.class, field);

                if(fieldToUpdate!=null) {
                    fieldToUpdate.setAccessible(true);

                    if(fieldToUpdate.getType().equals(LocalDate.class) && value instanceof String) {
                        try {
                            LocalDate parsedDate = LocalDate.parse((String) value);
                            ReflectionUtils.setField(fieldToUpdate, book, parsedDate);
                        } catch (DateTimeParseException e) {
                            throw new IllegalArgumentException("Invalid date format for field: " + field);
                        }
                    } else {
                        ReflectionUtils.setField(fieldToUpdate, book, value);
                    }
                    fieldToUpdate.setAccessible(false);
                } else {
                    throw new IllegalArgumentException("Field " + field + " does not exist on Book class");
                }
            });
        } else {
            throw new EntityNotFoundException("Book with ID " + bookId + " not found");
        }
        return bookRepository.save(book);
    }
}