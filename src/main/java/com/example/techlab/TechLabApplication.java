package com.example.techlab;

import com.example.techlab.dto.TestTypeDTO;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.Reactif;
import com.example.techlab.entities.TestType;
import com.example.techlab.entities.enums.Sexe;
import com.example.techlab.repositories.PatientRepository;
import com.example.techlab.repositories.ReactifRepository;
import com.example.techlab.repositories.TestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TechLabApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ReactifRepository reactifRepository;

    @Autowired
    private TestTypeRepository testTypeRepository;

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

        List<Patient> allPatients = patientRepository.findAll();
        System.out.println("All patients:");
        for (Patient p : allPatients) {
            System.out.println(p);
        }
        Reactif reactif = new Reactif();
        // Example 1
        Reactif reactif1 = new Reactif();
        reactif1.setNomReactif("Reactif A");
        reactif1.setDescription("Description for Reactif A");
        reactif1.setQuantiteReactif(15);
        reactif1.setDateExpiration(LocalDate.now().plusMonths(9)); // Assuming a 9-month expiration
        reactif1.setFournisseur("Supplier XYZ");
        reactifRepository.save(reactif1);

        // Example 2
        Reactif reactif2 = new Reactif();
        reactif2.setNomReactif("Reactif B");
        reactif2.setDescription("Description for Reactif B");
        reactif2.setQuantiteReactif(20);
        reactif2.setDateExpiration(LocalDate.now().minusMonths(12)); // Assuming a 12-month expiration
        reactif2.setFournisseur("Supplier DEF");
        reactifRepository.save(reactif2);


        // Example 3
        Reactif reactif3 = new Reactif();
        reactif3.setNomReactif("Reactif C");
        reactif3.setDescription("Description for Reactif C");
        reactif3.setQuantiteReactif(5);
        reactif3.setDateExpiration(LocalDate.now().plusMonths(8)); // Assuming an 8-month expiration
        reactif3.setFournisseur("Supplier GHI");
        reactifRepository.save(reactif3);

        TestType testType1 = TestType.builder().nomTest("Test A").max(10.0).min(5.0).unite("Unité A").build();
        testTypeRepository.save(testType1);

        TestType testType2 = TestType.builder().nomTest("Test B").max(20.0).min(15.0).unite("Unité B").build();
        testTypeRepository.save(testType2);

        TestType testType3 = TestType.builder().nomTest("Test C").max(30.0).min(25.0).unite("Unité C").build();
        testTypeRepository.save(testType3);

    }
}
