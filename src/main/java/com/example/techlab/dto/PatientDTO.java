package com.example.techlab.dto;

import com.example.techlab.entities.Patient;
import com.example.techlab.entities.enums.Sexe;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO  {
    private long id;
    private String nom;
    private String prenom;
    private LocalDate ddn;
    private Sexe sexe;
    private String adresse;
    private String telephone;
    private List<AnalyseDTO> analysesDTO;

}
