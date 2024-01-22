package com.example.techlab.entities;

import com.example.techlab.entities.enums.StatutAnalyse;
import com.example.techlab.entities.enums.TypeAnalyse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"analyse\"")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private TypeAnalyse typeAnalyse;
    private LocalDate dateEffet;
    private String commentaire;
    @JsonBackReference
    @ManyToOne
    private Patient patient;
    private StatutAnalyse statut;
    @ManyToOne
    @JoinColumn(name = "id_echantillon")
    private Echantillon echantillon;
    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Utilisateur technicien;

    @OneToMany(mappedBy = "analyse", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Test> testsList = new ArrayList<>();
}

