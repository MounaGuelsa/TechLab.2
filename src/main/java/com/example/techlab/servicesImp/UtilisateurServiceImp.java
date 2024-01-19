package com.example.techlab.servicesImp;

import com.example.techlab.dto.UtilisateurDTO;
import com.example.techlab.entities.Utilisateur;
import com.example.techlab.mapper.UtilisateurMapper;
import com.example.techlab.repositories.UtilisateurRepository;
import com.example.techlab.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImp implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Autowired
    public UtilisateurServiceImp(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public List<UtilisateurDTO> obtenirUtilisateurs() {
        List<UtilisateurDTO> utlisateur = utilisateurRepository
                .findAll()
                .stream()
                .map(utilisateurMapper::toDTO)
                .collect(Collectors.toList());
        return utlisateur;
    }

    @Override
    public UtilisateurDTO ajouterUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDTO(utilisateur);
    }

    @Override
    public UtilisateurDTO obtenirUtilisateurParId(Long idPatient) {
        return utilisateurRepository.findById(idPatient)
                .map(utilisateurMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void supprimerUtilisateur(Long idPatient) {
        utilisateurRepository.deleteById(idPatient);
    }
}
