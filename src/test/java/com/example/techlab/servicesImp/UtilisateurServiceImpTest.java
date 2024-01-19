package com.example.techlab.servicesImp;

import com.example.techlab.TechLabApplication;
import com.example.techlab.dto.PatientDTO;
import com.example.techlab.dto.UtilisateurDTO;
import com.example.techlab.entities.enums.Role;
import com.example.techlab.repositories.UtilisateurRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig(TechLabApplication.class)
class UtilisateurServiceImpTest {

    @Autowired
    private UtilisateurServiceImp utilisateurServiceImp;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private UtilisateurDTO utilisateurDTO1;
    private UtilisateurDTO utilisateurDTO2;
    private UtilisateurDTO utilisateurDTO3;
    @BeforeEach
    void setUp(){
        utilisateurRepository.deleteAll();

        utilisateurDTO1 = UtilisateurDTO
                .builder()
                .nomUtilisateur("Yassin1")
                .mdp("yassinmdp")
                .role(Role.ADMIN)
                .informationsPersonnelles("mes informatins perssonelles")
                .build();

        utilisateurDTO2 = UtilisateurDTO
                .builder()
                .nomUtilisateur("Yassin2")
                .mdp("yassinmdp")
                .role(Role.TECHNICIEN)
                .informationsPersonnelles("mes informatins perssonelles")
                .build();

        utilisateurDTO3 = UtilisateurDTO
                .builder()
                .nomUtilisateur("Yassin3")
                .mdp("yassinmdp")
                .role(Role.RESPONSABLE)
                .informationsPersonnelles("mes informatins perssonelles")
                .build();

    }

    @Test
    @Order(1)
    void obtenirUtilisateurs() {
        utilisateurServiceImp.ajouterUtilisateur(utilisateurDTO1);
        utilisateurServiceImp.ajouterUtilisateur(utilisateurDTO2);
        utilisateurServiceImp.ajouterUtilisateur(utilisateurDTO3);

        // act
        List<UtilisateurDTO> utilisateurDTOList = utilisateurServiceImp.obtenirUtilisateurs();

        // assert
        assertEquals(3, utilisateurDTOList.size());
    }

    @Test
    @Order(2)
    void ajouterUtilisateur() {
        utilisateurServiceImp.ajouterUtilisateur(utilisateurDTO1);

        // assert
        assertEquals(1, utilisateurRepository.count());
    }

    @Test
    @Order(3)
    void obtenirUtilisateurParId() {
        UtilisateurDTO utilisateurExiste = utilisateurServiceImp.ajouterUtilisateur(utilisateurDTO1);

        // act
        UtilisateurDTO utilisateurReturn = utilisateurServiceImp.obtenirUtilisateurParId(utilisateurExiste.getId());

        // assert
        assertNotNull(utilisateurReturn);
        assertEquals(utilisateurDTO1.getNomUtilisateur(), utilisateurReturn.getNomUtilisateur());
    }

  /*  @Test
    @Order(4)
    void supprimerUtilisateur() {
        UtilisateurDTO utilisateurExiste = utilisateurServiceImp.ajouterUtilisateur(utilisateurDTO1);
        UtilisateurDTO utilisateurReturn = utilisateurServiceImp.obtenirUtilisateurParId(utilisateurExiste.getId());
        utilisateurServiceImp.supprimerUtilisateur(utilisateurReturn.getId());
        assertNotNull(utilisateurReturn);
    }
*/
    @AfterEach
    void tearDown() {
        utilisateurRepository.deleteAll();

    }
}