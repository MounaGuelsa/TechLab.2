package com.example.techlab.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reactif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom_reactif")
    private String nomReactif;

    @Column(name = "description")
    private String description;

    @Column(name = "quantite_reactif")
    private double quantiteReactif;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_expiration")
    private Date dateExpiration;

    @Column(name = "fournisseur")
    private String fournisseur;

    @OneToMany(mappedBy = "reactif")
    private List<TestReactif> testReactifList;

}
