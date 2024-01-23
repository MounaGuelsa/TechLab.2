package com.example.techlab.servicesImp;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.Patient;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.AnalyseMapper;
import com.example.techlab.mapper.EchantillonMapper;
import com.example.techlab.repositories.AnalyseRepository;
import com.example.techlab.repositories.EchantillonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AnalyseServiceImpTest {
    @Mock
    private AnalyseRepository analyseRepository;
    @Mock
    private AnalyseMapper analyseMapper;
    @InjectMocks
    private AnalyseServiceImp analyseServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void obtenirAnalyses() {
        List<AnalyseDTO> expectedAnlayse = Arrays.asList(new AnalyseDTO(), new AnalyseDTO());
        when(analyseRepository.findAll()).thenReturn(Arrays.asList(new Analyse(), new Analyse()));
        when(analyseMapper.toDTO(any())).thenReturn(new AnalyseDTO());

        List<AnalyseDTO> actualAnalyse = analyseServiceImp.obtenirAnalyses();

        assertEquals(expectedAnlayse.size(), actualAnalyse.size());
        verify(analyseRepository, times(1)).findAll();

    }

    @Test
    void ajouterAnalyse() {
        AnalyseDTO analyseDTO = new AnalyseDTO();
        analyseDTO.setId(1L);
        Analyse analyse = new Analyse();
        analyse.setId(1L);
        when(analyseMapper.toEntity(analyseDTO)).thenReturn(analyse);
        when(analyseRepository.save(any(Analyse.class))).thenReturn(analyse);
        when(analyseMapper.toDTO(analyse)).thenReturn(analyseDTO);
        AnalyseDTO result = analyseServiceImp.ajouterAnalyse(analyseDTO);
        assertEquals(analyseDTO, result);
        verify(analyseRepository, times(1)).save(analyse);
        verify(analyseMapper, times(1)).toDTO(analyse);
        verify(analyseMapper, times(1)).toEntity(analyseDTO);

    }

    @Test
    void obtenirAnalyseParId() {
        Long idAnalyse = 1L;
        Analyse analyse = new Analyse();
        AnalyseDTO expectedAnalyseDTO = new AnalyseDTO();
        when(analyseRepository.findById(idAnalyse)).thenReturn(Optional.of(analyse));
        when(analyseMapper.toDTO(analyse)).thenReturn(expectedAnalyseDTO);

        // Act
        AnalyseDTO result = analyseServiceImp.obtenirAnalyseParId(idAnalyse);

        // Assert
        assertEquals(expectedAnalyseDTO, result);
        verify(analyseRepository, times(1)).findById(idAnalyse);
        verify(analyseMapper, times(1)).toDTO(analyse);
    }

    @Test
    void modifierAnalyse() {
        Long idAnalyse = 1L;
        AnalyseDTO nouvelleAnalyseDTO = new AnalyseDTO();
        nouvelleAnalyseDTO.setCommentaire("Nouveau Nom");

        // Add more fields as needed

        Analyse existingAnalyse = new Analyse();
        existingAnalyse.setId(idAnalyse);
        existingAnalyse.setCommentaire("Ancien Nom");

        // Add more fields as needed

        when(analyseRepository.findById(idAnalyse)).thenReturn(Optional.of(existingAnalyse));
        when(analyseRepository.save(existingAnalyse)).thenReturn(existingAnalyse); // Assuming modification updates the existing entity
        when(analyseMapper.toDTO(existingAnalyse)).thenReturn(nouvelleAnalyseDTO);

        // Act
        AnalyseDTO result = analyseServiceImp.modifierAnalyse(idAnalyse, nouvelleAnalyseDTO);

        // Assert
        assertEquals(nouvelleAnalyseDTO, result);
        assertEquals("Nouveau Nom", existingAnalyse.getCommentaire()); // Verify that the name is updated
        // Add more assertions for other fields as needed

        verify(analyseRepository, times(1)).findById(idAnalyse);
        verify(analyseRepository, times(1)).save(existingAnalyse);
        verify(analyseMapper, times(1)).toDTO(existingAnalyse);
    }

    @Test
    void supprimerAnalyse() {
        Long idExistePas = 1L;

        when(analyseRepository.findById(idExistePas)).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> analyseServiceImp.supprimerAnalyse(idExistePas));

        assertEquals("Analyse avec " + idExistePas + " est introuvable", exception.getMessage());
        verify(analyseRepository, times(1)).findById(idExistePas);
        verify(analyseRepository, never()).deleteById(idExistePas);
    }
}