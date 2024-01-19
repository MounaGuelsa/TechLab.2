package com.example.techlab.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="\"test_reactif\"")
public class TestReactif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="id_test")
    private Test test;
    @ManyToOne
    @JoinColumn(name="id_reactif")
    private Reactif reactif;
}
