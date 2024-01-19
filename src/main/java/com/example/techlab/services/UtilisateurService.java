package com.example.techlab.services;

import com.example.techlab.dto.UtilisateurDTO;


import java.util.List;

public interface UtilisateurService {
    public List<UtilisateurDTO> obtenirUtilisateurs();

    public UtilisateurDTO ajouterUtilisateur(UtilisateurDTO utilisateurDTO);

    public UtilisateurDTO obtenirUtilisateurParId(Long idPatient);

    public void supprimerUtilisateur(Long idPatient);

}
