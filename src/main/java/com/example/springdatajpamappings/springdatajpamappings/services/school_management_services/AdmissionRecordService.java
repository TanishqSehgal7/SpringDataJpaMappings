package com.example.springdatajpamappings.springdatajpamappings.services.school_management_services;

import com.example.springdatajpamappings.springdatajpamappings.entities.school_management_entities.AdmissionRecord;
import com.example.springdatajpamappings.springdatajpamappings.repositories.school_management_repositories.AdmissionRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordService {

    AdmissionRecordRepository admissionRecordRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public AdmissionRecord getAdmissionRecordById(Long admissionRecordId) {
        return admissionRecordRepository.findById(admissionRecordId).orElse(null);
    }

    public AdmissionRecord creteNewAdmissionRecord(AdmissionRecord admissionRecord) {
        return admissionRecordRepository.save(admissionRecord);
    }
    
}
