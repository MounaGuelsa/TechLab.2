package com.example.techlab.entities;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDateTime;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Table(name="planifications")

public class Planification extends Analyse {

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Utilisateur technicien;
}

