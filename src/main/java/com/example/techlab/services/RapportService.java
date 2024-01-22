package com.example.techlab.services;

import com.example.techlab.dto.PlanificationDTO;
import com.example.techlab.dto.RapportDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Rapport;

import java.util.List;

public interface RapportService {
    public List<RapportDTO> obtenirRapport();

    public RapportDTO ajouterRapport(RapportDTO rapportDTO);

    public RapportDTO obtenirRapportParId(Long idRapport);

    public RapportDTO modifierRapport(Long idRapport, RapportDTO rapportDTO);

    public void supprimerRapport(Long idRapport);
}
