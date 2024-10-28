package com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_author_mapping",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Author authorOfTheBooks;

    private LocalDateTime publishedDate;

}
