package com.example.jpa;

import com.example.jpa.entities.Appointment;
import com.example.jpa.entities.Insurance;
import com.example.jpa.services.AppointmentService;
import com.example.jpa.services.InsuranceService;
import com.example.jpa.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;

    @Test
    public void testAssignInsuranceToPatient(){
       Insurance insurance = Insurance.builder()
               .provider("HDFC")
               .policyNumber("HDFC_23")
               .validUntil(LocalDate.of(2030,1,1))
               .build();
       var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance,1L);
       System.out.println(updatedInsurance);
       patientService.deletePatient(1L);
    }

    @Test
    public void testCreateNewAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,1,1,11,0,0))
                .reason("fever")
                .build();
        var updatedAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(updatedAppointment);
    }
}
