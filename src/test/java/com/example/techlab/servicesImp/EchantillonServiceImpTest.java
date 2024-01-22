package com.example.techlab.servicesImp;

import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.entities.Echantillon;
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
        verify(echantillonMapper, times(1)).toDTO(any());
    }

    @Test
    void ajouterEchantillon() {
    }

    @Test
    void obtenirEchantillonParId() {
    }

    @Test
    void modifierEchantillon() {
    }

    @Test
    void supprimerEchantillon() {
    }
}