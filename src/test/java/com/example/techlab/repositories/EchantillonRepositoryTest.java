package com.example.techlab.repositories;

import com.example.techlab.TechLabApplication;
import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.enums.Sexe;
import com.example.techlab.entities.enums.StatutResultat;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig(TechLabApplication.class)
class EchantillonRepositoryTest {

    private EchantillonRepository echantillonRepository;
    private PatientRepository patientRepository;

    @Autowired
    public EchantillonRepositoryTest(PatientRepository patientRepository, EchantillonRepository echantillonRepository) {
        this.patientRepository = patientRepository;
        this.echantillonRepository = echantillonRepository;
    }

    private Echantillon echantillon1;
    private Echantillon echantillon2;
    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = Patient.builder()
                .nom("ayoub")
                .prenom("ahmed")
                .ddn(LocalDate.of(2000, 12, 12))
                .sexe(Sexe.MASCULIN)
                .adresse("casa")
                .telephone("066050505")
                .build();
        patient = patientRepository.save(patient);

        echantillon1 = Echantillon.builder()
                .type("sang")
                .datePrelevement(LocalDate.now())
                .patient(patient)

                .build();
        echantillon1 = echantillonRepository.save(echantillon1);
        echantillon1 = Echantillon.builder()
                .type("sang")
                .datePrelevement(LocalDate.now())
                .patient(patient)

                .build();
        echantillon1 = echantillonRepository.save(echantillon1);

    }

    @Test
    @Order(1)
    @DisplayName("Test get echantillon By Id")
    public void PatientRepository_GetById_ReturnEchantillon() {
        // arrange
        //act
        Optional<Echantillon> sampleOptional = echantillonRepository.findById(echantillon1.getId());
        //assert
        assertTrue(sampleOptional.isPresent());
        assertEquals(echantillon1.getId(), sampleOptional.get().getId());
    }

    @Test
    @Order(2)
    @DisplayName("Test get all echantillon")
    public void EchantillonRepository_GetAll_ReturnList() {
        // arrange
        //act
        List<Echantillon> listEchantillons = echantillonRepository.findAll();
        //assert
        assertFalse(listEchantillons.isEmpty());
        assertEquals(2, listEchantillons.size());
    }

    @Test
    @Order(3)
    @DisplayName("Test save echantillon")
    public void EchantillonRepository_Save_ReturnPatient() {
        // arrange
        Echantillon echantillonSaved = Echantillon.builder()
                .type("sang")
                .datePrelevement(LocalDate.now())
                .patient(patient)
                .build();

        //act
        echantillonRepository.save(echantillonSaved);

        //assert
        Optional<Echantillon> ech = echantillonRepository.findById(echantillonSaved.getId());
        assertEquals(echantillonSaved.getId(), ech.get().getId());
    }

        @Test
    @Order(4)
    @DisplayName("Test delete echantillon")
    public void EchantiollonRepository_Delete_ReturnFalse() {
        // arrange

        //act
        echantillonRepository.deleteById(echantillon1.getId());

        //assert
        Optional<Echantillon> echantillonSearch = echantillonRepository.findById(echantillon1.getId());
        assertFalse(echantillonSearch.isPresent());
    }
    @AfterEach
    void tearDown() {
        echantillonRepository.deleteAll();
    }
}