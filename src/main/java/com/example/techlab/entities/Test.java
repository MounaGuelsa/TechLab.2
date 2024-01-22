package com.example.techlab.entities;


import com.example.techlab.entities.enums.StatutResultat;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="\"tests\"")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    private Double resultat;
    private StatutResultat statutResultat;
    @ManyToOne
    private Analyse analyse;
    @ManyToOne
    @JoinColumn(name = "testType_id")
    private TestType testType;

    @OneToMany(mappedBy ="test" )
    private List<TestReactif> testReactifList;
}
