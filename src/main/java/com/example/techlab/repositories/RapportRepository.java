package com.example.techlab.repositories;

import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport,Long> {
}
