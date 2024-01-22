package com.example.techlab.repositories;

import com.example.techlab.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository  extends JpaRepository<Test,Long> {
}
