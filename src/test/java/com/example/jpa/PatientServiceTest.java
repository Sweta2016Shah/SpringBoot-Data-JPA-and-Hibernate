package com.example.jpa;

import com.example.jpa.dto.BloodGroupStats;
import com.example.jpa.dto.CPatientInfo;
import com.example.jpa.dto.IPatientInfo;
import com.example.jpa.entities.Patient;
import com.example.jpa.repositories.PatientRepository;
import com.example.jpa.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

//    @Test
//    public void testPatient(){
////        List<Patient> patientList = patientRepository.findAll();
////        List<IPatientInfo> patientList = patientRepository.getAllPatientsInfo();
////        for(IPatientInfo p: patientList){
////            System.out.println(p.getId() + " " + p.getName() + " " + p.getEmail());
////        }
//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
//        for(CPatientInfo p: patientList){
//            System.out.println(p);
//        }
//    }

//@Test
//public void testPatient(){
//    List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//    for(var p: patientList){
//        System.out.println(p);
//

    @Test
    public void testPatient(){
//        int rowsAffected = patientRepository.updatePatientNameWithId("Anuj Sharma", 1L);
//        System.out.println(rowsAffected);
        patientService.testPatientTransaction();
    }
}
