package com.example.techlab.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Reactif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom_reactif")
    private String nomReactif;

    @Column(name = "description")
    private String description;

    @Column(name = "quantite_reactif")
    private int quantiteReactif;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @Column(name = "fournisseur")
    private String fournisseur;

    @OneToMany(mappedBy = "reactif")
    private List<TestReactif> testReactifList;

}
