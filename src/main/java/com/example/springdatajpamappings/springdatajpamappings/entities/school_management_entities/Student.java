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
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "studentAdmissionRecord", fetch = FetchType.EAGER)
    @JsonIgnore
    private AdmissionRecord admissionRecord;

    private String studentName;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    List<Professor> professors;

    @ManyToMany
    @JoinTable(name = "student_subject_mapping",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    @JsonIgnore
    private List<Subject> studentSubjects;

}
