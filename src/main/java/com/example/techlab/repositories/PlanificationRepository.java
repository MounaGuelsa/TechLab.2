package com.example.techlab.repositories;

import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.Planification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanificationRepository  extends JpaRepository<Planification,Long> {
}
