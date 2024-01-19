package com.example.techlab.services;

import com.example.techlab.dto.ReactifDTO;
import com.example.techlab.dto.TestTypeDTO;

import java.util.List;

public interface TestTypeService {
    public List<TestTypeDTO> listeTestType();

    public TestTypeDTO ajouterTestType(TestTypeDTO testTypeDTO);

    public TestTypeDTO obtenirTestTypeParId(Long idReactif);

    public TestTypeDTO modifierTestType(Long idTestType, TestTypeDTO testTypeDTO);

    public void supprimerTestType(Long idTestType);
}
