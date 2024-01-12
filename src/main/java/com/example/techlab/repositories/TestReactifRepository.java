package com.example.techlab.repositories;

import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.TestReactif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestReactifRepository  extends JpaRepository<TestReactif,Long> {
}
