package com.example.techlab.repositories;

import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.TestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestTypeRepository extends JpaRepository<TestType,Long> {
}
