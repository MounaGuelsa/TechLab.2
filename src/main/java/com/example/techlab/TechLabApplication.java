package com.example.techlab;

import com.example.techlab.entities.Patient;
import com.example.techlab.entities.enums.Sexe;
import com.example.techlab.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TechLabApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(TechLabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setNom("Doe");
        patient.setPrenom("John");
//        patient.setDdn(new LocalD);
        patient.setSexe(Sexe.MASCULIN);
        patient.setAdresse("123 Main St");
        patient.setTelephone("1234567890");
        // Save the patient
        patientRepository.save(patient);
        System.out.println(patient.toString());
//
        List<Patient> allPatients = patientRepository.findAll();
        System.out.println("All patients:");
        for (Patient p : allPatients) {
            System.out.println(p);
        }

    }
}
