package com.example.techlab.repositories;

import com.example.techlab.TechLabApplication;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.Utilisateur;
import com.example.techlab.entities.enums.Role;
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
class UtilisateurRepositoryTest {

    private UtilisateurRepository UtilisateurRepository;

    @Autowired
    public UtilisateurRepositoryTest(UtilisateurRepository utilisateurRepository) {
        this.UtilisateurRepository = utilisateurRepository;
    }

    private Utilisateur utilisateur1;
    private Utilisateur utilisateur2;

    @BeforeEach
    void setUp() {
        utilisateur1 = Utilisateur.builder()
                .nomUtilisateur("moona")
                .mdp("1234")
                .role(Role.ADMIN)
                .informationsPersonnelles("nada")
                .build();

        utilisateur1= UtilisateurRepository.save(utilisateur1);

        utilisateur2 = Utilisateur.builder()
                .nomUtilisateur("moona")
                .mdp("1234")
                .role(Role.ADMIN)
                .informationsPersonnelles("nada")
                .build();
        utilisateur2 = UtilisateurRepository.save(utilisateur2);
    }

    @Test
    @Order(1)
    @DisplayName("Test get user By Id")
    public void UtilisateurRepository_GetById_ReturnUtilisateur() {
        // arrange
        //act
        Optional<Utilisateur> sampleOptional = UtilisateurRepository.findById(utilisateur1.getId());
        //assert
        assertTrue(sampleOptional.isPresent());
        assertEquals(utilisateur1.getId(),sampleOptional.get().getId());
    }
    @Test
    @Order(2)
    @DisplayName("Test get all users")
    public void UtilisateurRepository_GetAll_ReturnList() {
        // arrange
        //act
        List<Utilisateur> utilisateursList = UtilisateurRepository.findAll();
        //assert
        assertFalse(utilisateursList.isEmpty());
        assertEquals(2,utilisateursList.size());
    }
    @Test
    @Order(3)
    @DisplayName("Test save user")
    public void UtilisateurRepository_Save_ReturnUtilisateur() {
        // arrange
        Utilisateur utilisateurSaved = Utilisateur.builder()
                .nomUtilisateur("khokha")
                .mdp("1234")
                .role(Role.ADMIN)
                .informationsPersonnelles("nothing to kn")
                .build();
        utilisateurSaved= UtilisateurRepository.save(utilisateurSaved);

        //assert
        Optional<Utilisateur> user = UtilisateurRepository.findById(utilisateurSaved.getId());
        assertEquals(utilisateurSaved.getId(),user.get().getId());
    }
    @Test
    @Order(4)
    @DisplayName("Test delete user")
    public void UtilisateurRepository_Delete_ReturnFalse() {
        // arrange

        //act
        UtilisateurRepository.deleteById(utilisateur1.getId());

        //assert
        Optional<Utilisateur> userSearch = UtilisateurRepository.findById(utilisateur1.getId());
        assertFalse(userSearch.isPresent());
    }
    @AfterEach
    void tearDown() {
        UtilisateurRepository.deleteAll();
    }
}