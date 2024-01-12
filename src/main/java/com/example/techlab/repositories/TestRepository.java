package com.example.techlab.repositories;

import com.example.techlab.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository  extends JpaRepository<Test,Long> {
}
