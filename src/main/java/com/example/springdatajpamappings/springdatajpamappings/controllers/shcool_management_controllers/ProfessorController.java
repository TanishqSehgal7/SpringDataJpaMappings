package com.example.springdatajpamappings.springdatajpamappings.controllers.shcool_management_controllers;

import com.example.springdatajpamappings.springdatajpamappings.dto.ProfessorSubjectDto;
import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Professor;
import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

    ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{professorId}")
    public Professor getProfessorById(Long professorId) {
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public Professor createNewProfessorForExistingSubject(@RequestBody ProfessorSubjectDto professorSubjectDto) {
        return professorService.createNewProfessorForExistingSubject(professorSubjectDto);
    }

}
