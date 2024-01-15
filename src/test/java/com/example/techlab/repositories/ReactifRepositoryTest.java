package com.example.techlab.repositories;

import com.example.techlab.TechLabApplication;
import com.example.techlab.entities.Reactif;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig(TechLabApplication.class)
class ReactifRepositoryTest {
    private ReactifRepository reactifRepository;

    @Autowired
    public ReactifRepositoryTest(ReactifRepository reactifRepository) {
        this.reactifRepository = reactifRepository;
    }

    private Reactif reactif1;
    private Reactif reactif2;

    @BeforeEach
    void setUp() {
        reactif1 = Reactif.builder()
                .nomReactif("ss")
                .description("desc")
                .quantiteReactif(15)
                .dateExpiration(LocalDate.of(2020, 12, 12))
                .fournisseur("fournisseur")
                .build();
        reactifRepository.save(reactif1);

        reactif2 = Reactif.builder()
                .nomReactif("ss1")
                .description("desc")
                .quantiteReactif(15)
                .dateExpiration(LocalDate.of(2020, 12, 12))
                .fournisseur("fournisseur")
                .build();
        reactifRepository.save(reactif2);
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    @DisplayName("shouldReturnReactifWhenGettingById")
    public void shouldReturnReactifWhenGettingById() {
        // arrange
        // act
        Optional<Reactif> sampleOptional = reactifRepository.findById(reactif1.getId());
        // assert
        assertTrue(sampleOptional.isPresent());
        assertEquals(reactif1.getId(), sampleOptional.get().getId());
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    @DisplayName("shouldReturnAllReactifs")
    public void shouldReturnAllReactifs() {
        // arrange
        // act
        List<Reactif> reactifList = reactifRepository.findAll();
        // assert
        assertFalse(reactifList.isEmpty());
        assertEquals(2, reactifList.size());
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    @DisplayName("shouldSaveReactifAndReturnReactif")
    public void shouldSaveReactifAndReturnReactif() {
        // arrange
        Reactif reactif3 = Reactif.builder()
                .nomReactif("ss1")
                .description("desc")
                .quantiteReactif(15)
                .dateExpiration(LocalDate.of(2020, 12, 12))
                .fournisseur("fournisseur")
                .build();
        // act
        reactifRepository.save(reactif3);

        // assert
        Optional<Reactif> savedReactif = reactifRepository.findById(reactif3.getId());
        assertEquals(reactif3.getId(), savedReactif.get().getId());
    }

    @org.junit.jupiter.api.Test
    @Order(4)
    @DisplayName("shouldDeleteReactifById")
    public void shouldDeleteReactifById() {
        // arrange
        // act
        reactifRepository.deleteById(reactif1.getId());
        // assert
        Optional<Reactif> reactifSearch = reactifRepository.findById(reactif1.getId());
        assertFalse(reactifSearch.isPresent());
    }

    @AfterEach
    void tearDown() {
        reactifRepository.deleteAll();
    }
}
