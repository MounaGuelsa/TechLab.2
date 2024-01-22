package com.example.techlab.dto;


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
    private Long patientId;
    private StatutAnalyse statut;
    private Long echantillonId;
    private Long technicienId;
    private List<TestDTO> testsList;
}
