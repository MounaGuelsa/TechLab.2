package com.example.techlab.repositories;

import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport,Long> {
}
