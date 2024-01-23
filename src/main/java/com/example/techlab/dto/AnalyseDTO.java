package com.example.techlab.dto;


import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.Utilisateur;
import com.example.techlab.entities.enums.StatutAnalyse;
import com.example.techlab.entities.enums.TypeAnalyse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnalyseDTO {
    private long id;
    private TypeAnalyse typeAnalyse;
    private Date dateEffet;
    private String commentaire;
    private PatientDTO patientDTO;
    private StatutAnalyse statut;
    private EchantillonDTO echantillonDTO;
    private UtilisateurDTO technicienDTO;
    private List<TestDTO> testsListDTO;
}
