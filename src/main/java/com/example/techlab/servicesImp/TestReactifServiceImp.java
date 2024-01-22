package com.example.techlab.servicesImp;

import com.example.techlab.dto.TestReactifDTO;
import com.example.techlab.mapper.TestReactifMapper;
import com.example.techlab.repositories.TestReactifRepository;
import com.example.techlab.services.TestReactifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestReactifServiceImp implements TestReactifService {
    private final TestReactifRepository testReactifRepository;
    private final TestReactifMapper testReactifMapper;

    @Autowired
    public TestReactifServiceImp(TestReactifRepository testReactifRepository, TestReactifMapper testReactifMapper) {
        this.testReactifRepository = testReactifRepository;
        this.testReactifMapper = testReactifMapper;
    }

    @Override
    public List<TestReactifDTO> listeTestReactif() {
        return null;
    }

    @Override
    public TestReactifDTO ajouterTestReactif(TestReactifDTO testReactifDTO) {
        return null;
    }

    @Override
    public TestReactifDTO obtenirTestReactifParId(Long idReactif) {
        return null;
    }

    @Override
    public TestReactifDTO modifierTestReactif(Long idTestReactif, TestReactifDTO testReactifDTO) {
        return null;
    }

    @Override
    public void supprimerTestReactif(Long idTestReactif) {

    }
}
