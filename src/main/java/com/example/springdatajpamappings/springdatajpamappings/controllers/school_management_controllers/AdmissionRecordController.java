package com.example.springdatajpamappings.springdatajpamappings.controllers.school_management_controllers;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.AdmissionRecord;
import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admissionRecords")
public class AdmissionRecordController {

    AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping("/{admissionRecordId}")
    public AdmissionRecord getAdmissionRecordById(@PathVariable Long admissionRecordId) {
        return admissionRecordService.getAdmissionRecordById(admissionRecordId);
    }

    @PostMapping
    public AdmissionRecord creteNewAdmissionRecord(@RequestBody AdmissionRecord admissionRecord) {
        return admissionRecordService.creteNewAdmissionRecord(admissionRecord);
    }

}
