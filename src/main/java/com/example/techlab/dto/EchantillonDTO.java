package com.example.techlab.dto;


import com.example.techlab.entities.Patient;
import com.example.techlab.entities.enums.StatutResultat;
import com.example.techlab.entities.enums.TypeAnalyse;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EchantillonDTO {

    private long id;
    private String type;
    private String description;
    private LocalDate datePrelevement;
    private TypeAnalyse typeAnalyse;
    private Patient patient;
    private List<AnalyseDTO> analysesList;
   }

