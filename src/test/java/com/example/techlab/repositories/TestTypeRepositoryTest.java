package com.example.techlab.repositories;

import com.example.techlab.TechLabApplication;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.TestType;
import com.example.techlab.entities.enums.Sexe;
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
class TestTypeRepositoryTest {

    private TestTypeRepository testTypeRepository;

    @Autowired
    public TestTypeRepositoryTest(TestTypeRepository testTypeRepository) {
        this.testTypeRepository = testTypeRepository;
    }

    private TestType testType1;
    private TestType testType2;

    @BeforeEach
    void setUp() {
        testType1 = TestType.builder()
                .nomTest("homoglobinne")
                .min(12)
                .max(70)
                .unite("ml")
                .build();
        testType1 = testTypeRepository.save(testType1);
        testType2 = TestType.builder()
                .nomTest("homoglobinne5")
                .min(12)
                .max(70)
                .unite("ml")
                .build();
        testType2 = testTypeRepository.save(testType2);
    }

    @Test
    @Order(1)
    @DisplayName("Test get testType By Id")
    public void TestTypeRepository_GetById_ReturnTestType() {
        // arrange
        //act
        Optional<TestType> sampleOptional = testTypeRepository.findById(testType1.getId());
        //assert
        assertTrue(sampleOptional.isPresent());
        assertEquals(testType1.getId(),sampleOptional.get().getId());
    }
    @Test
    @Order(2)
    @DisplayName("Test get all testType")
    public void TestTypeRepository_GetAll_ReturnList() {
        // arrange
        //act
        List<TestType> testTypeList = testTypeRepository.findAll();
        //assert
        assertFalse(testTypeList.isEmpty());
        assertEquals(2,testTypeList.size());
    }
    @Test
    @Order(3)
    @DisplayName("Test save testType")
    public void TestTypeRepository_Save_ReturnTestType() {
        // arrange
        TestType testType = TestType.builder()
                .nomTest("TEST4")
                .min(12)
                .max(70)
                .unite("ml")
                .build();

        //act
        testTypeRepository.save(testType);

        //assert
        Optional<TestType> test = testTypeRepository.findById(testType.getId());
        assertEquals(testType.getId(),test.get().getId());
    }
    @Test
    @Order(4)
    @DisplayName("Test delete testType")
    public void PatientRepository_Delete_ReturnFalse() {
        // arrange

        //act
        testTypeRepository.deleteById(testType1.getId());

        //assert
        Optional<TestType> testSearch = testTypeRepository.findById(testType1.getId());
        assertFalse(testSearch.isPresent());
    }
    @AfterEach
    void tearDown() {
        testTypeRepository.deleteAll();
    }
}