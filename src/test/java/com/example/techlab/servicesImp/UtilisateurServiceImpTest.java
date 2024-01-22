package com.example.techlab.servicesImp;

import com.example.techlab.dto.UtilisateurDTO;
import com.example.techlab.entities.Utilisateur;
import com.example.techlab.entities.enums.Role;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.UtilisateurMapper;
import com.example.techlab.repositories.UtilisateurRepository;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

class UtilisateurServiceImpTest {

    @Mock
    private UtilisateurMapper utilisateurMapper;
    @Mock
    private UtilisateurRepository utilisateurRepository;
    @InjectMocks
    private UtilisateurServiceImp utilisateurService;

    @BeforeEach

    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void obtenirUtilisateurs() {
        // act
        List<UtilisateurDTO> utilisateurAttendus = Arrays.asList(new UtilisateurDTO(), new UtilisateurDTO());
        when(utilisateurRepository.findAll()).thenReturn(Arrays.asList(new Utilisateur(), new Utilisateur()));
        when(utilisateurMapper.toDTO(any(Utilisateur.class))).thenReturn(new UtilisateurDTO());

        // assert
        List<UtilisateurDTO> utilisateurReel = utilisateurService.obtenirUtilisateurs();

        assertEquals(utilisateurAttendus.size(), utilisateurReel.size());
        verify(utilisateurRepository, times(1)).findAll();
        verify(utilisateurMapper, times(2)).toDTO(any());
    }
    @Test
    void ajouterUtilisateur(){

        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setNomUtilisateur("Yassin");
        utilisateurDTO.setMdp("1234");
        utilisateurDTO.setRole(Role.ADMIN);
        utilisateurDTO.setInformationsPersonnelles("nada");

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);

        when(utilisateurMapper.toEntity(utilisateurDTO)).thenReturn(utilisateur);
        when(utilisateurRepository.save(any(Utilisateur.class))).thenReturn(utilisateur);
        when(utilisateurMapper.toDTO(utilisateur)).thenReturn(utilisateurDTO);

        UtilisateurDTO result = utilisateurService.ajouterUtilisateur(utilisateurDTO);

        assertEquals(utilisateurDTO, result);

        verify(utilisateurMapper, times(1)).toDTO(utilisateur);
        verify(utilisateurMapper, times(1)).toEntity(utilisateurDTO);
        verify(utilisateurRepository, times(1)).save(utilisateur);
    }
    @Test
    void obtenirUtilisateurParId(){
        Long id = 1L;
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurDTO utilisateurDTOAttendus = new UtilisateurDTO();

        when(utilisateurRepository.findById(id)).thenReturn(Optional.of(utilisateur));
        when(utilisateurMapper.toDTO(utilisateur)).thenReturn(utilisateurDTOAttendus);

        UtilisateurDTO result = utilisateurService.obtenirUtilisateurParId(id);

        assertEquals(utilisateurDTOAttendus, result);

        verify(utilisateurRepository, times(1)).findById(id);
        verify(utilisateurMapper, times(1)).toDTO(utilisateur);


    }
    @Test
    void supprimerUtilisateur(){
        Long id = 1L;

        when(utilisateurRepository.findById(id)).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> utilisateurService.supprimerUtilisateur(id));

        assertEquals("patient avec 1 est introuvable", exception.getMessage());
        verify(utilisateurRepository, times(1)).findById(id);
        verify(utilisateurRepository, never()).deleteById(id);
    }

    @Test
    void modifierUtilisateur(){

    }

    @AfterEach
    void tearDown() {
        utilisateurRepository.deleteAll();

    }
}