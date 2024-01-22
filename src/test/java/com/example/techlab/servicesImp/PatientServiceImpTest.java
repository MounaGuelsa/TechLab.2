package com.example.techlab.servicesImp;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Patient;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.PatientMapper;
import com.example.techlab.repositories.PatientRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;


class PatientServiceImpTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @InjectMocks
    private PatientServiceImp patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testObtenirPatients() {
        // Arrange
        List<PatientDTO> expectedPatients = Arrays.asList(new PatientDTO(), new PatientDTO());
        when(patientRepository.findAll()).thenReturn(Arrays.asList(new Patient(), new Patient()));
        when(patientMapper.toDTO(any())).thenReturn(new PatientDTO());

        // Act
        List<PatientDTO> actualPatients = patientService.obtenirPatients();

        // Assert
        assertEquals(expectedPatients.size(), actualPatients.size());
        verify(patientRepository, times(1)).findAll();
        verify(patientMapper, times(2)).toDTO(any());
    }

    @Test
    void testAjouterPatient() {
        // Arrange
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setAdresse("hm");

        Patient patient = new Patient();
        patient.setId(1L);

        when(patientMapper.toEntity(patientDTO)).thenReturn(patient);
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);
        when(patientMapper.toDTO(patient)).thenReturn(patientDTO);

        // Act
        PatientDTO result = patientService.ajouterPatient(patientDTO);

        // Assert
        assertEquals(patientDTO, result);

        verify(patientRepository, times(1)).save(patient);
        verify(patientMapper, times(1)).toDTO(patient);
        verify(patientMapper, times(1)).toEntity(patientDTO);
    }

    @Test
    void testObtenirPatientParId_ExistingId() {
        // Arrange
        Long idPatient = 1L;
        Patient patient = new Patient();
        PatientDTO expectedPatientDTO = new PatientDTO();
        when(patientRepository.findById(idPatient)).thenReturn(Optional.of(patient));
        when(patientMapper.toDTO(patient)).thenReturn(expectedPatientDTO);

        // Act
        PatientDTO result = patientService.obtenirPatientParId(idPatient);

        // Assert
        assertEquals(expectedPatientDTO, result);
        verify(patientRepository, times(1)).findById(idPatient);
        verify(patientMapper, times(1)).toDTO(patient);
    }

    @Test
    void testObtenirPatientParId_NonExistingId() {
        // Arrange
        Long idPatient = 1L;
        when(patientRepository.findById(idPatient)).thenReturn(Optional.empty());

        // Act & Assert
        CustomException exception = assertThrows(CustomException.class,
                () -> patientService.obtenirPatientParId(idPatient));

        assertEquals("patient avec 1  est introuvable ", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        verify(patientRepository, times(1)).findById(idPatient);
        verify(patientMapper, never()).toDTO(any());
    }

    @Test
    void testSupprimerPatient() {
        // Arrange
        Long idExistePas = 1L;

        when(patientRepository.findById(idExistePas)).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> patientService.supprimerPatient(idExistePas));

        assertEquals("patient avec 1 est introuvable", exception.getMessage());
        verify(patientRepository, times(1)).findById(idExistePas);
        verify(patientRepository, never()).deleteById(idExistePas);

    }
}
