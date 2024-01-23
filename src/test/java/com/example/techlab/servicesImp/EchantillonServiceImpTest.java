package com.example.techlab.servicesImp;

import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.entities.Echantillon;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.EchantillonMapper;
import com.example.techlab.repositories.EchantillonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class EchantillonServiceImpTest {
    @Mock
    private EchantillonRepository echantillonRepository;
    @Mock
    private EchantillonMapper echantillonMapper;
    @InjectMocks
    private EchantillonServiceImp echantillonService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void obtenirEchantillons() {
        List<EchantillonDTO> expectedEchantillons = Arrays.asList(new EchantillonDTO(), new EchantillonDTO());
        when(echantillonRepository.findAll()).thenReturn(Arrays.asList(new Echantillon(), new Echantillon()));
        when(echantillonMapper.toDTO(any())).thenReturn(new EchantillonDTO());

        List<EchantillonDTO> actualEchantillons = echantillonService.obtenirEchantillons();

        assertEquals(expectedEchantillons.size(), actualEchantillons.size());
        verify(echantillonRepository, times(1)).findAll();
        verify(echantillonMapper, times(2)).toDTO(any());
    }

    @Test
    void ajouterEchantillon() {
        EchantillonDTO echantillonDTO = new EchantillonDTO();


        Echantillon echantillon = new Echantillon();
        echantillon.setId(1L);

        when(echantillonMapper.toEntity(echantillonDTO)).thenReturn(echantillon);
        when(echantillonRepository.save(any(Echantillon.class))).thenReturn(echantillon);
        when(echantillonMapper.toDTO(echantillon)).thenReturn(echantillonDTO);

        // Act
        EchantillonDTO result = echantillonService.ajouterEchantillon(echantillonDTO);

        // Assert
        assertEquals(echantillonDTO, result);

        verify(echantillonRepository, times(1)).save(echantillon);
        verify(echantillonMapper, times(1)).toDTO(echantillon);
        verify(echantillonMapper, times(1)).toEntity(echantillonDTO);
    }

    @Test
    void obtenirEchantillonParId() {
        Long idEchantillon = 1L;
        Echantillon echantillon = new Echantillon();
        EchantillonDTO expectedEchantillonDTO = new EchantillonDTO();
        when(echantillonRepository.findById(idEchantillon)).thenReturn(Optional.of(echantillon));
        when(echantillonMapper.toDTO(echantillon)).thenReturn(expectedEchantillonDTO);

        // Act
        EchantillonDTO result = echantillonService.obtenirEchantillonParId(idEchantillon);

        // Assert
        assertEquals(expectedEchantillonDTO, result);
        verify(echantillonRepository, times(1)).findById(idEchantillon);
        verify(echantillonMapper, times(1)).toDTO(echantillon);
    }

    @Test
    void modifierEchantillon() {
        Long idEchantillon = 1L;
        EchantillonDTO echantillonDTO = new EchantillonDTO();
        echantillonDTO.setDescription("nouvelle discr");

        Echantillon existingEchantillon = new Echantillon();
        existingEchantillon.setId(idEchantillon);
        existingEchantillon.setDescription("ancienne discr");

        when(echantillonRepository.findById(idEchantillon)).thenReturn(Optional.of(existingEchantillon));
        when(echantillonMapper.toEntity(echantillonDTO)).thenReturn(existingEchantillon); // Assuming modification updates the existing entity
        when(echantillonRepository.save(existingEchantillon)).thenReturn(existingEchantillon);
        when(echantillonMapper.toDTO(existingEchantillon)).thenReturn(echantillonDTO);

        // Act
        EchantillonDTO result = echantillonService.modifierEchantillon(idEchantillon, echantillonDTO);

        // Assert
        assertEquals(echantillonDTO, result);
        assertEquals("nouvelle discr", existingEchantillon.getDescription()); // Verify that the address is updated

        verify(echantillonRepository, times(1)).findById(idEchantillon);
        verify(echantillonRepository, times(1)).save(existingEchantillon);
        verify(echantillonMapper, times(1)).toDTO(existingEchantillon);

    }

    @Test
    void supprimerEchantillon() {
        Long idExistePas = 1L;

        when(echantillonRepository.findById(idExistePas)).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> echantillonService.supprimerEchantillon(idExistePas));

        assertEquals("echantillon avec "+idExistePas+"  est introuvable ", exception.getMessage());
        verify(echantillonRepository, times(1)).findById(idExistePas);
        verify(echantillonRepository, never()).deleteById(idExistePas);
    }
}