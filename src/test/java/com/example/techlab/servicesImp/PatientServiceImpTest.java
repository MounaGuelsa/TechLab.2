package com.example.techlab.servicesImp;

import com.example.techlab.TechLabApplication;
import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.enums.Sexe;
import com.example.techlab.repositories.PatientRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Import des classes nécessaires

@SpringBootTest
@SpringJUnitConfig(TechLabApplication.class)
class PatientServiceImpTest {

    @Autowired
    private PatientServiceImp patientServiceImp;
    @Autowired
    private PatientRepository patientRepository;



    private PatientDTO patientDTO1;
    private PatientDTO patientDTO2;
    private PatientDTO patientDTO3;

    @BeforeEach
    void setUp() {
        patientRepository.deleteAll();
        patientDTO1 = PatientDTO.builder()
                .nom("ayoub")
                .prenom("ahmed")
                .ddn(LocalDate.of(2000, 12, 12))
                .sexe(Sexe.MASCULIN)
                .adresse("casa")
                .telephone("066050505")
                .build();

        patientDTO2 = PatientDTO.builder()
                .nom("mouna")
                .prenom("ahmed")
                .ddn(LocalDate.of(2000, 12, 12))
                .sexe(Sexe.MASCULIN)
                .adresse("casa")
                .telephone("066050505")
                .build();

        patientDTO3 = PatientDTO.builder()
                .nom("chaimaa")
                .prenom("ahmed")
                .ddn(LocalDate.of(2000, 12, 12))
                .sexe(Sexe.MASCULIN)
                .adresse("casa")
                .telephone("066050505")
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("Test 1: obtenir la liste des patients")
    void obtenirPatientsTest() {
        // arrange
        patientServiceImp.ajouterPatient(patientDTO1);
        patientServiceImp.ajouterPatient(patientDTO2);
        patientServiceImp.ajouterPatient(patientDTO3);

        // act
        List<PatientDTO> patients = patientServiceImp.obtenirPatients();

        // assert
        assertEquals(3, patients.size());
    }

    @Test
    @Order(2)
    @DisplayName("Test 2: ajouter un patient")
    void ajouterPatientTest() {
        // arrange
        // act
        patientServiceImp.ajouterPatient(patientDTO1);

        // assert
        assertEquals(1, patientRepository.count());
    }

    @Test
    @Order(3)
    @DisplayName("Test 3: obtenir patient par id")
    void obtenirPatientParId() {
        // arrange
        PatientDTO addedPatient = patientServiceImp.ajouterPatient(patientDTO1);

        // act
        PatientDTO retrievedPatient = patientServiceImp.obtenirPatientParId(addedPatient.getId());

        // assert
        assertNotNull(retrievedPatient);
        assertEquals(patientDTO1.getNom(), retrievedPatient.getNom());
    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
    }
}
