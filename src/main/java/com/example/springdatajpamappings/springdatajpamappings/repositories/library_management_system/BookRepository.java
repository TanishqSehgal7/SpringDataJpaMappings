package com.example.springdatajpamappings.springdatajpamappings.repositories.library_management_system;

import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.bookName= :bookName")
    Optional<Book> findByBookName(@Param("bookName") String bookName);

    Optional<List<Book>> findByPublishedDateAfter(LocalDate publishedDate);

    List<Book> findByAuthorOfTheBooks_Id(Long authorId);
}