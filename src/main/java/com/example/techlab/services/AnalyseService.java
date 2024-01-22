package com.example.techlab.services;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.dto.EchantillonDTO;

import java.util.List;

public interface AnalyseService {
    public List<AnalyseDTO> obtenirAnalyses();

    public AnalyseDTO ajouterAnalyse(AnalyseDTO analyseDTO);

    public AnalyseDTO obtenirAnalyseParId(Long idAnalyse);

    public AnalyseDTO modifierAnalyse(Long idAnalyse, AnalyseDTO analyseDTO);

    public void supprimerAnalyse(Long idAnalyse);
}
