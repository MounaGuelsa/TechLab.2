package com.example.techlab.services;

import com.example.techlab.dto.TestDTO;

import java.util.List;

public interface TestService {
    public List<TestDTO> listTest();

    public TestDTO ajouterTest(TestDTO testDTO);

    public TestDTO obtenirTestParId(Long idReactif);

    public TestDTO modifierTest(Long idTest, TestDTO testDTO);

    public void supprimerTest(Long idTest);
}
