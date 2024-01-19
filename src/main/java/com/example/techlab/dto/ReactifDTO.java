package com.example.techlab.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactifDTO {
    private long id;
    private String nomReactif;
    private String description;
    private int quantiteReactif;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateExpiration;

    private String fournisseur;
    //private List<TestReactifDto> testReactifList;
}
