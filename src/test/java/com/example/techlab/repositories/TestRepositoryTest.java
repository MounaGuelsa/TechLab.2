package com.example.techlab.repositories;

import com.example.techlab.TechLabApplication;
import com.example.techlab.entities.Test;
import com.example.techlab.entities.TestType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Optional;

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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig(TechLabApplication.class)
class TestRepositoryTest {

    private TestRepository testRepository;

    @Autowired
    private TestTypeRepository testTypeRepository;

    private Test test1;
    private Test test2;

    @BeforeEach
    void setUp() {
        TestType testType = TestType.builder()
                .nomTest("homoglobinne")
                .min(12)
                .max(70)
                .unite("ml")
                .build();
        testType = testTypeRepository.save(testType);

        test1 = Test.builder()
                .label("testx")
                .resultat(18.0)
                .testType(testType)
                .build();
        test1 = testRepository.save(test1);

        test2 = Test.builder()
                .label("testx")
                .resultat(18.0)
                .testType(testType)
                .build();
        test2 = testRepository.save(test2);
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    @DisplayName("shouldReturnTestTypeWhenGettingById")
    public void shouldReturnTestTypeWhenGettingById() {
        // arrange
        // act
        Optional<Test> sampleOptional = testRepository.findById(test1.getId());
        // assert
        assertTrue(sampleOptional.isPresent());
        assertEquals(test1.getId(), sampleOptional.get().getId());
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    @DisplayName("shouldReturnAllTests")
    public void shouldReturnAllTests() {
        // arrange
        // act
        List<Test> testList = testRepository.findAll();
        // assert
        assertFalse(testList.isEmpty());
        assertEquals(2, testList.size());
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    @DisplayName("shouldSaveTestAndReturnTestType")
    public void shouldSaveTestAndReturnTestType() {
        // arrange
        Test test = Test.builder()

                .label("testx")
                .resultat(18.0)
                .build();
        // act
        testRepository.save(test);
        // assert
        Optional<Test> savedTest = testRepository.findById(test.getId());
        assertEquals(test.getId(), savedTest.get().getId());
    }

    @org.junit.jupiter.api.Test
    @Order(4)
    @DisplayName("shouldDeleteTestById")
    public void shouldDeleteTestById() {
        // arrange
        // act
        testRepository.deleteById(test1.getId());
        // assert
        Optional<Test> testSearch = testRepository.findById(test1.getId());
        assertFalse(testSearch.isPresent());
    }

    @AfterEach
    void tearDown() {
        testRepository.deleteAll();
    }
}
