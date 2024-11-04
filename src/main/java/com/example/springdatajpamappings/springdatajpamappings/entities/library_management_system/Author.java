package com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authorName;

    @OneToMany(mappedBy = "authorOfTheBooks", fetch = FetchType.EAGER)
    private List<Book> books;

}
