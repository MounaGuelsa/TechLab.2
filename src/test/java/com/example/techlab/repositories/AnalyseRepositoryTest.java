package com.example.techlab.repositories;

import com.example.techlab.TechLabApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@SpringJUnitConfig(TechLabApplication.class)
class AnalyseRepositoryTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }
}