package com.example.techlab.repositories;

import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Echantillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseRepository  extends JpaRepository<Analyse,Long> {
}
