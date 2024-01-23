package com.example.techlab.dto;

import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.TestType;
import com.example.techlab.entities.enums.StatutResultat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDTO {
    private long id;
    private String label;
    private Double resultat;
    private StatutResultat statutResultat;
    private Analyse analyse;
    private TestTypeDTO testTypeDTO;
}
