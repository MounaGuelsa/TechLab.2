package com.example.techlab.entities;

import com.example.techlab.entities.enums.Sexe;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "\"patients\"")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private long id;

    @Column(name = "nom_patient")
    private String nom;

    @Column(name = "prenom_patient")
    private String prenom;

    @Column(name = "ddn_patient")
    private LocalDate ddn;

    @Column(name = "sexe_patient")
    private Sexe sexe;

    @Column(name = "adresse_patient")
    private String adresse;

    @Column(name = "telephone_patient")
    private String telephone;
//    @JsonManagedReference
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Analyse> analyses;
}
