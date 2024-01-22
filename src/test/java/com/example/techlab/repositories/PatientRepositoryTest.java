package com.example.techlab.repositories;

import com.example.techlab.TechLabApplication;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.enums.Sexe;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig(TechLabApplication.class)
class PatientRepositoryTest {
    private PatientRepository patientRepository;

    @Autowired
    public PatientRepositoryTest(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    private Patient patient1;
    private Patient patient2;

    @BeforeEach
    void setUp() {
        patient1 = Patient.builder()
                .nom("ayoub")
                .prenom("ahmed")
                .ddn(LocalDate.of(2000, 12, 12))
                .sexe(Sexe.MASCULIN)
                .adresse("casa")
                .telephone("066050505")
                .build();
        patient1 = patientRepository.save(patient1);
        patient2 = Patient.builder()
                .nom("ayoub2")
                .prenom("ahmed2")
                .ddn(LocalDate.of(2000, 12, 12))
                .sexe(Sexe.MASCULIN)
                .adresse("casa")
                .telephone("066050505")
                .build();
        patient2 = patientRepository.save(patient2);
    }

    @Test
    @Order(1)
    @DisplayName("Test get patient By Id")
    public void PatientRepository_GetById_ReturnPatient() {
        // arrange
        //act
        Optional<Patient> sampleOptional = patientRepository.findById(patient1.getId());
        //assert
        assertTrue(sampleOptional.isPresent());
        assertEquals(patient1.getId(),sampleOptional.get().getId());
    }
    @Test
    @Order(2)
    @DisplayName("Test get all patient")
    public void PatientRepository_GetAll_ReturnList() {
        // arrange
        //act
        List<Patient> listPatient = patientRepository.findAll();
        //assert
        assertFalse(listPatient.isEmpty());
        assertEquals(2,listPatient.size());
    }
    @Test
    @Order(3)
    @DisplayName("Test save patient")
    public void PatientRepository_Save_ReturnPatient() {
        // arrange
        Patient patientSaved = Patient.builder()
                .nom("Yassin")
                .prenom("prenom")
                .ddn(LocalDate.of(2003, 12, 12))
                .sexe(Sexe.MASCULIN)
                .adresse("casablanca Maroc")
                .telephone("0606060606")
                .build();

        //act
        patientRepository.save(patientSaved);

        //assert
        Optional<Patient> patient5 = patientRepository.findById(patientSaved.getId());
        assertTrue(patient5.isPresent());
        assertEquals(patientSaved.getId(),patient5.get().getId());
    }
    @Test
    @Order(4)
    @DisplayName("Test delete patient")
    public void PatientRepository_Delete_ReturnFalse() {
        // arrange

        //act
        patientRepository.deleteById(patient1.getId());

        //assert
        Optional<Patient> patientSearch = patientRepository.findById(patient1.getId());
        assertFalse(patientSearch.isPresent());
    }
    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
    }
}