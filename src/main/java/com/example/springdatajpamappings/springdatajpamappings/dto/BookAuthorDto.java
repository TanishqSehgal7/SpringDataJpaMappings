package com.example.springdatajpamappings.springdatajpamappings.dto;


import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Author;
import com.example.springdatajpamappings.springdatajpamappings.entities.library_management_system.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorDto {

    private String bookName;
    private String publishedDate;
    private String authorName;

}
