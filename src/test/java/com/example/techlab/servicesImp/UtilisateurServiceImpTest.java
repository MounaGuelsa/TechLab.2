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
    void modifierUtilisateur(){
        Long idUtilisateur = 1L;
        UtilisateurDTO nouvelUtilisateurDTO = new UtilisateurDTO();
        nouvelUtilisateurDTO.setNomUtilisateur("Nouveau Nom");
        nouvelUtilisateurDTO.setMdp("Nouveau Mdp");

        // Add more fields as needed

        Utilisateur existingUtilisateur = new Utilisateur();
        existingUtilisateur.setId(idUtilisateur);
        existingUtilisateur.setNomUtilisateur("Ancien Nom");
        existingUtilisateur.setMdp("Ancien Mdp");

        // Add more fields as needed

        when(utilisateurRepository.findById(idUtilisateur)).thenReturn(Optional.of(existingUtilisateur));
        when(utilisateurRepository.save(existingUtilisateur)).thenReturn(existingUtilisateur); // Assuming modification updates the existing entity
        when(utilisateurMapper.toDTO(existingUtilisateur)).thenReturn(nouvelUtilisateurDTO);

        // Act
        UtilisateurDTO result = utilisateurService.modifierUtilisateur(idUtilisateur, nouvelUtilisateurDTO);

        // Assert
        assertEquals(nouvelUtilisateurDTO, result);
        assertEquals("Nouveau Nom", existingUtilisateur.getNomUtilisateur()); // Verify that the name is updated
        assertEquals("Nouveau Mdp", existingUtilisateur.getMdp()); // Verify that the surname is updated


        verify(utilisateurRepository, times(1)).findById(idUtilisateur);
        verify(utilisateurRepository, times(1)).save(existingUtilisateur);
        verify(utilisateurMapper, times(1)).toDTO(existingUtilisateur);

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



    @AfterEach
    void tearDown() {
        utilisateurRepository.deleteAll();

    }
}