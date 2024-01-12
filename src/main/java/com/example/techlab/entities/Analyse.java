package com.example.techlab.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date dateEffet;
    private String commentaire;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_echantillon")
    private Echantillon echantillon;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Utilisateur technicien;

    @OneToMany(mappedBy = "analyse", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Test> testsList= new ArrayList<>();
}

