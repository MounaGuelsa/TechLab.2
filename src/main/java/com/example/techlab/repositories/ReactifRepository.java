package com.example.techlab.repositories;

import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.Reactif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactifRepository  extends JpaRepository<Reactif,Long> {
}
