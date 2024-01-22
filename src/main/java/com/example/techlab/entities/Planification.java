package com.example.techlab.entities;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="\"planifications\"")

public class Planification extends Analyse {

    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Utilisateur technicien;

}

