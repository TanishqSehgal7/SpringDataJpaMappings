package com.example.springdatajpamappings.springdatajpamappings.controllers.shcool_management_controllers;

import com.example.springdatajpamappings.springdatajpamappings.services.school_management_services.AdmissionRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admissionRecords")
public class AdmissionRecordController {

    AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    public

}
