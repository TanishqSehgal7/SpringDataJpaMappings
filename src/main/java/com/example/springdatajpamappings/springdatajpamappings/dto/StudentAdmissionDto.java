package com.example.springdatajpamappings.springdatajpamappings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAdmissionDto {

    private String studentName;
    private Integer fees;
}
