package com.example.techlab.entities;

import com.example.techlab.entities.enums.StatutEchantillon;
import com.example.techlab.entities.enums.StatutResultat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "echantillons")
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "echantillon_id")
    private long id;

    @Column(name = "type_echantillon")
    private String type;

    @Column(name = "date_prelevement")
    private LocalDate datePrelevement;

    @Column(name = "statut_echantillon")
    private StatutEchantillon statutEchantillon;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @OneToMany(mappedBy = "echantillon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Analyse> analysesList;

    @Column(name = "statut_resultat")
    private StatutResultat statutResultat;
}
