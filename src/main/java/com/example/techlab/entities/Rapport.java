package com.example.techlab.entities;

import com.example.techlab.entities.enums.Periode;
import lombok.*;

import javax.persistence.*;
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type ;
    private Periode periode;
    @ManyToOne
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;

}
