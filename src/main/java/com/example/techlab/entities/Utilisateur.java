package com.example.techlab.entities;

import com.example.techlab.entities.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="utilisateurs")
public class Utilisateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String nomUtilisateur;
    private String mdp;
    private Role role;
    private String informationsPersonnelles;
    @OneToMany(mappedBy = "technicien")
    private List<Analyse> analyses;

    @OneToMany(mappedBy = "technicien")
    private List<Planification> planifications;
}
