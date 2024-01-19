package com.example.techlab.entities;

import com.example.techlab.entities.enums.StatutAnalyse;
import com.example.techlab.entities.enums.TypeAnalyse;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "analyses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private TypeAnalyse typeAnalyse;
    private Date dateEffet;
    private String commentaire;

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
    private List<Test> testsList= new ArrayList<>();
}

