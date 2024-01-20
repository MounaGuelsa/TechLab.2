package com.example.techlab.services;

import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Analyse;

import java.util.List;

public interface EchantillonService {
    public List<EchantillonDTO> obtenirEchantillons();

    public EchantillonDTO ajouterEchantillon(EchantillonDTO echantillonDTO);

    public EchantillonDTO obtenirEchantillonParId(Long idEchantillon);

    public EchantillonDTO modifierEchantillon(Long idEchantillon, EchantillonDTO echantillonDTO);

    public void supprimerEchantillon(Long idEchantillon);

}
