package com.example.techlab.controllers;


import com.example.techlab.dto.PatientDTO;
import com.example.techlab.dto.UtilisateurDTO;
import com.example.techlab.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }
    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> obtenirUtilisateur() {
        List<UtilisateurDTO> utilsateurs = utilisateurService.obtenirUtilisateurs();
        return new ResponseEntity<>(utilsateurs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UtilisateurDTO> ajouterUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        UtilisateurDTO utilisateur = utilisateurService.ajouterUtilisateur(utilisateurDTO);
        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> obtenirUtilisateurParId(@PathVariable long id) {
        UtilisateurDTO utilisateur = utilisateurService.obtenirUtilisateurParId(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> supprimerUtilisateur(@PathVariable long id) {
        utilisateurService.supprimerUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> modifierUtilisateur(@PathVariable long id) {
        UtilisateurDTO utilisateur = utilisateurService.obtenirUtilisateurParId(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

}
