package com.example.techlab.servicesImp;

import com.example.techlab.dto.ReactifDTO;
import com.example.techlab.entities.Reactif;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.ReactifMapper;
import com.example.techlab.repositories.ReactifRepository;
import com.example.techlab.services.ReactifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReactifServiceImp implements ReactifService {
    private final ReactifRepository reactifRepository;
    private final ReactifMapper reactifMapper;

    @Autowired
    public ReactifServiceImp(ReactifRepository reactifRepository, ReactifMapper reactifMapper) {
        this.reactifRepository = reactifRepository;
        this.reactifMapper = reactifMapper;
    }


    @Override
    public List<ReactifDTO> listeReactifs() {
        List<ReactifDTO> reactifs = reactifRepository.findAll().stream()
                .map(reactifMapper::toDTO)
                .collect(Collectors.toList());
        return reactifs;
    }

    @Override
    public ReactifDTO ajouterReactif(ReactifDTO reactifDTO) {
        try {
            Reactif reactif = reactifMapper.toEntity(reactifDTO);
            reactifRepository.save(reactif);
            return reactifMapper.toDTO(reactif);
        } catch (Exception e) {
            throw new CustomException("Erreur lors de l'ajout du réactif", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ReactifDTO obtenirReactifParId(Long idReactif) {
        Optional<Reactif> reactifOptional = reactifRepository.findById(idReactif);
        if (!reactifOptional.isPresent()) {
            throw new CustomException("reactif avec " + idReactif + "  est introuvable ", HttpStatus.NOT_FOUND);
        } else {
            ReactifDTO reactifDTO = reactifMapper.toDTO(reactifOptional.get());
            return reactifDTO;
        }
    }

    @Override
    public ReactifDTO modifierReactif(Long idReactif, ReactifDTO reactifDTO) {
        Optional<Reactif> existingReactifOptional = reactifRepository.findById(idReactif);
        if(!existingReactifOptional.isPresent())
        {
            throw new CustomException("Reactif avec " + idReactif + " est introuvable", HttpStatus.NOT_FOUND);
        }
        Reactif existingReactif= existingReactifOptional.get();
        existingReactif.setNomReactif(reactifDTO.getNomReactif());
        existingReactif.setQuantiteReactif(reactifDTO.getQuantiteReactif());
        existingReactif.setDateExpiration(reactifDTO.getDateExpiration());
        existingReactif.setFournisseur(reactifDTO.getFournisseur());
        existingReactif.setDescription(reactifDTO.getDescription());
        Reactif updatedReactif=reactifRepository.save(existingReactif);


        return reactifMapper.toDTO(updatedReactif);
    }
    @Override
    public void supprimerReactif(Long idReactif) {
        Optional<Reactif> reactifOptional = reactifRepository.findById(idReactif);
        if (!reactifOptional.isPresent()) {
            throw new CustomException("reactif avec " + idReactif + "  est introuvable ", HttpStatus.NOT_FOUND);
        } else {
            reactifRepository.deleteById(idReactif);
        }
    }
    @Override
    public List<ReactifDTO> reactifExpire() {
        List<ReactifDTO> reactifs = listeReactifs();

        LocalDate currentDate = LocalDate.now();

        return reactifs.stream()
                .filter(reactif -> reactif.getDateExpiration() == null || reactif.getDateExpiration().isBefore(currentDate))
                .collect(Collectors.toList());
    }
    @Override
    public List<ReactifDTO> reactifReptureEnStock() {
        List<ReactifDTO> reactifs = listeReactifs();
        int seuilRuptureStock = 10;

        return reactifs.stream()
                .filter(reactif -> reactif.getQuantiteReactif() <= seuilRuptureStock)
                .collect(Collectors.toList());
    }
}
