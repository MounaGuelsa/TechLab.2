//package com.example.techlab.controllers;
//
//import com.example.techlab.dto.PatientDTO;
//import com.example.techlab.services.PatientService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.mockito.Mockito;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//class PatientControllerTest {
//
//    @Mock
//    private PatientService patientService;
//
//    @InjectMocks
//    private PatientController patientController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void obtenirPatients() {
//        // Arrange
//        List<PatientDTO> mockPatients = Collections.singletonList(new PatientDTO());
//        when(patientService.obtenirPatients()).thenReturn(mockPatients);
//
//        // Act
//        ResponseEntity<List<PatientDTO>> response = patientController.obtenirPatients();
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(mockPatients, response.getBody());
//    }
//
//    @Test
//    void ajouterPatient() {
//        // Arrange
//        PatientDTO mockPatientDTO = new PatientDTO(/* actual patient data */);
//        when(patientService.ajouterPatient(any())).thenReturn(mockPatientDTO);
//
//        // Act
//        ResponseEntity<PatientDTO> response = patientController.ajouterPatient(mockPatientDTO);
//
//        // Assert
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(mockPatientDTO, response.getBody());
//    }
//
//    @Test
//    void obtenirPatientParId() {
//        // Arrange
//        Long patientId = 1L;
//        PatientDTO mockPatientDTO = new PatientDTO(/* actual patient data */);
//        when(patientService.obtenirPatientParId(patientId)).thenReturn(mockPatientDTO);
//
//        // Act
//        ResponseEntity<PatientDTO> response = patientController.obtenirPatientParId(patientId);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(mockPatientDTO, response.getBody());
//    }
//
//    @Test
//    void supprimerPatient() {
//        // Arrange
//        Long patientId = 1L;
//
//        // Act
//        ResponseEntity<Void> response = patientController.supprimerPatient(patientId);
//
//        // Assert
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        // Verify that the supprimerPatient method was called with the correct patientId
//        Mockito.verify(patientService, Mockito.times(1)).supprimerPatient(patientId);
//    }
//}
