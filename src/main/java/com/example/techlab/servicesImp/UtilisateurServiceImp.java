package com.example.techlab.servicesImp;

import com.example.techlab.dto.UtilisateurDTO;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.Utilisateur;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.UtilisateurMapper;
import com.example.techlab.repositories.UtilisateurRepository;
import com.example.techlab.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public UtilisateurDTO obtenirUtilisateurParId(Long idUtilisateur) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(idUtilisateur);
        if (!utilisateurOptional.isPresent()){
            throw new CustomException("utilisateur avec "+idUtilisateur+"  est introuvable ", HttpStatus.NOT_FOUND);
        }else {
            UtilisateurDTO utilisateurDTO = utilisateurMapper.toDTO(utilisateurOptional.get());
            return utilisateurDTO;
        }
    }

    @Override
    public UtilisateurDTO modifierUtilisateur(Long idUtilisateur, UtilisateurDTO utilisateurDTO) {
        Optional<Utilisateur> existingUtilisateurOptional = utilisateurRepository.findById(idUtilisateur);

        if (!existingUtilisateurOptional.isPresent()) {
            throw new CustomException("Utilisateur avec " + idUtilisateur + " est introuvable", HttpStatus.NOT_FOUND);
        }

        Utilisateur existingUtilisateur = existingUtilisateurOptional.get();

        existingUtilisateur.setNomUtilisateur(utilisateurDTO.getNomUtilisateur());
        existingUtilisateur.setMdp(utilisateurDTO.getMdp());
        existingUtilisateur.setRole(utilisateurDTO.getRole());
        existingUtilisateur.setInformationsPersonnelles(utilisateurDTO.getInformationsPersonnelles());

        Utilisateur updatedUpdated = utilisateurRepository.save(existingUtilisateur);
        return utilisateurMapper.toDTO(updatedUpdated);
    }

    @Override
    public void supprimerUtilisateur(Long idUtilisateur) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(idUtilisateur);
        if (!utilisateurOptional.isPresent()) {
            throw new CustomException("patient avec "+idUtilisateur+" est introuvable", HttpStatus.NOT_FOUND);
        } else {
            utilisateurRepository.deleteById(idUtilisateur);;

        }
    }

}
