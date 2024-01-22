package com.example.techlab.services;

import com.example.techlab.dto.TestReactifDTO;

import java.util.List;

public interface TestReactifService {
    public List<TestReactifDTO> listeTestReactif();

    public TestReactifDTO ajouterTestReactif(TestReactifDTO testReactifDTO);

    public TestReactifDTO obtenirTestReactifParId(Long idReactif);

    public TestReactifDTO modifierTestReactif(Long idTestReactif, TestReactifDTO testReactifDTO);

    public void supprimerTestReactif(Long idTestReactif);

}
