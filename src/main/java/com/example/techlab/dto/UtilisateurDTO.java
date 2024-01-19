package com.example.techlab.dto;

import com.example.techlab.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
   /* @OneToMany(mappedBy = "technicien")
    private List<Analyse> analyses;

    @OneToMany(mappedBy = "technicien")
    private List<Planification> planifications;*/
}
