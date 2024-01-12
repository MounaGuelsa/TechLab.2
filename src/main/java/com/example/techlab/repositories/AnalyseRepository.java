package com.example.techlab.repositories;

import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Echantillon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyseRepository  extends JpaRepository<Analyse,Long> {
}
