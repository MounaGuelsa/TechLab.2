package com.example.techlab.dto;

import com.example.techlab.entities.Analyse;
//import com.example.techlab.entities.Planification;
import com.example.techlab.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurDTO {
    private long id;
    private String nomUtilisateur;
    private String mdp;
    private Role role;
    private String informationsPersonnelles;
    private List<Analyse> analyses;
    //private List<Planification> planifications;
    //user dtos
}
