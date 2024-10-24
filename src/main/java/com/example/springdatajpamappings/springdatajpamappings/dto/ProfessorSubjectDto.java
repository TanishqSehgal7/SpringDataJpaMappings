package com.example.springdatajpamappings.springdatajpamappings.dto;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorSubjectDto {

    private String professorName;
    private List<Long> subjectIds;
}
