package com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subjectName;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    @JsonIgnore
    private Professor professor;

    @ManyToMany(mappedBy = "studentSubjects", fetch = FetchType.EAGER)
    private List<Student> studentList;

}
