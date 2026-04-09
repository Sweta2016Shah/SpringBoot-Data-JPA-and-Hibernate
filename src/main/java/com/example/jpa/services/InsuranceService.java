package com.example.jpa.services;

import com.example.jpa.entities.Insurance;
import com.example.jpa.entities.Patient;
import com.example.jpa.repositories.InsuranceRepository;
import com.example.jpa.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance); //dirty patient
        insurance.setPatient(patient); //Optional
        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance); //dirty patient
        insurance.setPatient(patient); //Optional
        return insurance;
    }

    @Transactional
    public Patient removeInsuranceToPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null); //dirty patient
        return patient;
    }

}
