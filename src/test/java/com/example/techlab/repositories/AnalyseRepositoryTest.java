//package com.example.techlab.repositories;
//
//import com.example.techlab.TechLabApplication;
//import com.example.techlab.entities.Analyse;
//import com.example.techlab.entities.Echantillon;
//import com.example.techlab.entities.Patient;
//import com.example.techlab.entities.Test;
//import com.example.techlab.entities.Utilisateur;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@SpringJUnitConfig(TechLabApplication.class)
//class AnalyseRepositoryTest {
//
//    @Autowired
//    private AnalyseRepository analyseRepository;
//
//    private Analyse analyse1;
//    private Analyse analyse2;
//
//    @BeforeEach
//    void setUp() {
//        Patient patient = new Patient(); // Assuming you have a Patient entity
//        Echantillon echantillon = new Echantillon(); // Assuming you have an Echantillon entity
//        Utilisateur technicien = new Utilisateur(); // Assuming you have a Utilisateur entity
//
//        analyse1 = Analyse.builder()
//                .dateEffet(new Date())
//                .commentaire("Test Commentaire")
//                .patient(patient)
//                .echantillon(echantillon)
//                .technicien(technicien)
//                .build();
//
//        analyse2 = Analyse.builder()
//                .dateEffet(new Date())
//                .commentaire("Test Commentaire")
//                .patient(patient)
//                .echantillon(echantillon)
//                .technicien(technicien)
//                .build();
//
//
//        analyseRepository.save(analyse1);
//        analyseRepository.save(analyse2);
//    }
//
//    @org.junit.jupiter.api.Test
//    @Order(1)
//    @DisplayName("shouldReturnAnalyseWhenGettingById")
//    public void shouldReturnAnalyseWhenGettingById() {
//        // arrange
//        // act
//        Optional<Analyse> analyseOptional = analyseRepository.findById(analyse1.getId());
//        // assert
//        assertTrue(analyseOptional.isPresent());
//        assertEquals(analyse1.getId(), analyseOptional.get().getId());
//    }
//
//    @org.junit.jupiter.api.Test
//    @Order(2)
//    @DisplayName("shouldReturnAllAnalyses")
//    public void shouldReturnAllAnalyses() {
//        // arrange
//        // act
//        List<Analyse> analyseList = analyseRepository.findAll();
//        // assert
//        assertFalse(analyseList.isEmpty());
//        assertEquals(2, analyseList.size());
//    }
//
////    @org.junit.jupiter.api.Test
////    @Order(3)
////    @DisplayName("shouldSaveAnalyseAndReturnAnalyse")
////    public void shouldSaveAnalyseAndReturnAnalyse() {
////        // arrange
////        Analyse analyse3 = Analyse.builder()
////                .dateEffet(new Date())
////                .commentaire("Test Commentaire")
////
////                .build();
////
////        // act
////        analyseRepository.save(analyse3);
////
////        // assert
////        Optional<Analyse> savedAnalyse = analyseRepository.findById(analyse3.getId());
////        assertEquals(analyse3.getId(), savedAnalyse.get().getId());
////    }
////
////    @org.junit.jupiter.api.Test
////    @Order(4)
////    @DisplayName("shouldDeleteAnalyseById")
////    public void shouldDeleteAnalyseById() {
////        // arrange
////        // act
////        analyseRepository.deleteById(analyse1.getId());
////        // assert
////        Optional<Analyse> analyseSearch = analyseRepository.findById(analyse1.getId());
////        assertFalse(analyseSearch.isPresent());
////    }
//
//    @AfterEach
//    void tearDown() {
//        analyseRepository.deleteAll();
//    }
//}
