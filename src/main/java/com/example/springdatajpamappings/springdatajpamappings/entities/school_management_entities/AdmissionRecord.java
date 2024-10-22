package com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AdmissionRecord")
public class AdmissionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer fees;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student studentAdmissionRecord;

}
