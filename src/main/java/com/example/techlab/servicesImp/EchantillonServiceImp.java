package com.example.techlab.servicesImp;

import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.Patient;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.EchantillonMapper;
import com.example.techlab.repositories.EchantillonRepository;
import com.example.techlab.services.EchantillonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EchantillonServiceImp implements EchantillonService {
    private final EchantillonRepository echantillonRepository;
    private final EchantillonMapper echantillonMapper;

    public EchantillonServiceImp(EchantillonRepository echantillonRepository, EchantillonMapper echantillonMapper) {
        this.echantillonRepository = echantillonRepository;
        this.echantillonMapper = echantillonMapper;
    }

    @Override
    public List<EchantillonDTO> obtenirEchantillons() {
        List<EchantillonDTO> echantillonDTOList = echantillonRepository
                .findAll()
                .stream()
                .map(echantillonMapper::toDTO)
                .collect(Collectors.toList());
        return echantillonDTOList;
    }

    @Override
    public EchantillonDTO ajouterEchantillon(EchantillonDTO echantillonDTO) {
        Echantillon echantillon= echantillonMapper.toEntity(echantillonDTO);
        echantillonRepository.save(echantillon);
        return echantillonMapper.toDTO(echantillon);
    }

    @Override
    public EchantillonDTO obtenirEchantillonParId(Long idEchantillon) {
        Optional<Echantillon> echantillonOptional = echantillonRepository.findById(idEchantillon);
        if(!echantillonOptional.isPresent())
        {
            throw new CustomException("echantillon avec "+idEchantillon+"  est introuvable ", HttpStatus.NOT_FOUND);
        }
        return echantillonMapper.toDTO(echantillonOptional.get());
    }

    @Override
    public EchantillonDTO modifierEchantillon(Long idEchantillon, EchantillonDTO echantillonDTO) {
        Optional<Echantillon> existingEchantillonOptional = echantillonRepository.findById(idEchantillon);

        if (!existingEchantillonOptional.isPresent()) {
            throw new CustomException("echantillon avec "+idEchantillon+"  est introuvable", HttpStatus.NOT_FOUND);
        }
        Echantillon echantillon= existingEchantillonOptional.get();
        echantillon.setType(echantillonDTO.getType());
        echantillon.setDescription(echantillonDTO.getDescription());
        echantillon.setDatePrelevement(echantillonDTO.getDatePrelevement());
        echantillon.setTypeAnalyse(echantillonDTO.getTypeAnalyse());
        Echantillon echantillonUpdated = echantillonRepository.save(echantillon);

        return echantillonMapper.toDTO(echantillonUpdated);
    }

    @Override
    public void supprimerEchantillon(Long idEchantillon) {
        Optional<Echantillon> echantillonOptional = echantillonRepository.findById(idEchantillon);
        if (!echantillonOptional.isPresent()) {
            throw new CustomException("echantillon avec "+idEchantillon+"  est introuvable ", HttpStatus.NOT_FOUND);
        } else {
            echantillonRepository.deleteById(idEchantillon);;

        }
    }
}
