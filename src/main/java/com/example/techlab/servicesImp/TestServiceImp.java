package com.example.techlab.servicesImp;

import com.example.techlab.dto.TestDTO;
import com.example.techlab.mapper.TestMapper;
import com.example.techlab.repositories.TestRepository;
import com.example.techlab.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImp implements TestService {
    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Autowired
    public TestServiceImp(TestRepository testRepository, TestMapper testMapper) {
        this.testRepository = testRepository;
        this.testMapper = testMapper;
    }

    @Override
    public List<TestDTO> listTest() {
        return null;
    }

    @Override
    public TestDTO ajouterTest(TestDTO testDTO) {
        return null;
    }

    @Override
    public TestDTO obtenirTestParId(Long idReactif) {
        return null;
    }

    @Override
    public TestDTO modifierTest(Long idTest, TestDTO testDTO) {
        return null;
    }

    @Override
    public void supprimerTest(Long idTest) {

    }
}
