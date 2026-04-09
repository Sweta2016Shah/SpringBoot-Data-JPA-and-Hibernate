package com.example.jpa.services;

import com.example.jpa.entities.Appointment;
import com.example.jpa.entities.Doctor;
import com.example.jpa.entities.Patient;
import com.example.jpa.repositories.AppointmentRepository;
import com.example.jpa.repositories.DoctorRepository;
import com.example.jpa.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointmentRepository.save(appointment);
        return appointment;
    }
}
