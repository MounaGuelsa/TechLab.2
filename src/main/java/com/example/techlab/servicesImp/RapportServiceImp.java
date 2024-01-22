package com.example.techlab.servicesImp;

import com.example.techlab.dto.RapportDTO;
import com.example.techlab.mapper.RapportMapper;
import com.example.techlab.repositories.RapportRepository;
import com.example.techlab.services.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportServiceImp implements RapportService {
    private final RapportRepository rapportRepository;
    private final RapportMapper rapportMapper;

    @Autowired
    public RapportServiceImp(RapportRepository rapportRepository, RapportMapper rapportMapper) {
        this.rapportRepository = rapportRepository;
        this.rapportMapper = rapportMapper;
    }

    @Override
    public List<RapportDTO> obtenirRapport() {
        return null;
    }

    @Override
    public RapportDTO ajouterRapport(RapportDTO rapportDTO) {
        return null;
    }

    @Override
    public RapportDTO obtenirRapportParId(Long idRapport) {
        return null;
    }

    @Override
    public RapportDTO modifierRapport(Long idRapport, RapportDTO rapportDTO) {
        return null;
    }

    @Override
    public void supprimerRapport(Long idRapport) {

    }
}

