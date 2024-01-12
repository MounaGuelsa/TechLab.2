package com.example.techlab.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="testtypes")
public class TestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomTest;
    private double max;
    private double min;
    private String unite;
}
