package com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author authorOfTheBooks;

    private LocalDate publishedDate;

}
