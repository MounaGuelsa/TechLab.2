package com.example.techlab.servicesImp;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.AnalyseMapper;
import com.example.techlab.mapper.UtilisateurMapper;
import com.example.techlab.repositories.AnalyseRepository;
import com.example.techlab.repositories.UtilisateurRepository;
import com.example.techlab.services.AnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnalyseServiceImp implements AnalyseService {

    private final AnalyseRepository analyseRepository;
    private final AnalyseMapper analyseMapper;
    @Autowired
    public AnalyseServiceImp(AnalyseRepository analyseRepository, AnalyseMapper analyseMapper) {
        this.analyseRepository = analyseRepository;
        this.analyseMapper = analyseMapper;
    }


    @Override
    public List<AnalyseDTO> obtenirAnalyses() {
        List<AnalyseDTO> analyseDTOList = analyseRepository
                .findAll()
                .stream()
                .map(analyseMapper::toDTO)
                .collect(Collectors.toList());
        return analyseDTOList;
    }

    @Override
    public AnalyseDTO ajouterAnalyse(AnalyseDTO analyseDTO) {
        Analyse analyse = analyseMapper.toEntity(analyseDTO);
        analyseRepository.save(analyse);
        return analyseMapper.toDTO(analyse);
    }

    @Override
    public AnalyseDTO obtenirAnalyseParId(Long idAnalyse) {
        Optional<Analyse> analyseOptional = analyseRepository.findById(idAnalyse);
        if (!analyseOptional.isPresent()) {
            throw new CustomException("Analyse avec " + idAnalyse + " est introuvable", HttpStatus.NOT_FOUND);
        } else {
            AnalyseDTO analyseDTO = analyseMapper.toDTO(analyseOptional.get());
            return analyseDTO;
        }
    }

    @Override
    public AnalyseDTO modifierAnalyse(Long idAnalyse, AnalyseDTO analyseDTO) {
        Optional<Analyse> analyseOptional = analyseRepository.findById(idAnalyse);
        if (!analyseOptional.isPresent()) {
            throw new CustomException("Analyse avec " + idAnalyse + " est introuvable", HttpStatus.NOT_FOUND);
        }
        Analyse existingAnalyse = analyseOptional.get();
        existingAnalyse.setTypeAnalyse(analyseDTO.getTypeAnalyse());
        existingAnalyse.setDateEffet(analyseDTO.getDateEffet());
        existingAnalyse.setCommentaire(analyseDTO.getCommentaire());
/*
        existingAnalyse.setPatient(analyseRepository.findBy(analyseDTO.getPatientId()));
*/
        existingAnalyse.setStatut(analyseDTO.getStatut());
/*
        existingAnalyse.setEchantillon();
*/
/*
        existingAnalyse.setTechnicien(analyseDTO.getTechnicienId());
*/
/*
        existingAnalyse.setTestsList(analyseDTO.getTestsList());
*/
        // we have some work here above

        Analyse updatedAnalyse = analyseRepository.save(existingAnalyse);
        return analyseMapper.toDTO(updatedAnalyse);
    }

    @Override
    public void supprimerAnalyse(Long idAnalyse) {
        Optional<Analyse> analyseOptional = analyseRepository.findById(idAnalyse);
        if (!analyseOptional.isPresent()) {
            throw new CustomException("Analyse avec " + idAnalyse + " est introuvable", HttpStatus.NOT_FOUND);
        }else {
            analyseRepository.deleteById(idAnalyse);
        }
    }
}
