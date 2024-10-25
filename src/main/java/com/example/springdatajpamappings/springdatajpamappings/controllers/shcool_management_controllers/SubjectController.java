package com.example.springdatajpamappings.springdatajpamappings.controllers.shcool_management_controllers;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.Subject;
import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subjects")
public class SubjectController {

    SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{studentId}")
    public Subject getSubjectById(@PathVariable Long subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public List<Subject> createNewSubject(@RequestBody Subject subject) {
        return subjectService.createNewSubject(subject);
    }

    @PutMapping(path = "/{subjectId}/students/{studentId}")
    public Subject assignStudentsToSubjects(@PathVariable Long subjectId, @PathVariable Long studentId) {
        return subjectService.assignStudentsToSubjects(subjectId, studentId);
    }

}
