package com.example.techlab.servicesImp;

import com.example.techlab.dto.TestDTO;
import com.example.techlab.entities.Test;
import com.example.techlab.entities.enums.StatutResultat;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.TestMapper;
import com.example.techlab.repositories.TestRepository;
import com.example.techlab.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
        return testRepository.findAll().stream()
                .map(testMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestDTO ajouterTest(TestDTO testDTO) {
        try {
            Test test = testMapper.toEntity(testDTO);
            testRepository.save(test);

            return testMapper.toDTO(test);

        } catch (Exception e) {
            // Handle exception appropriately
            // You might want to log the exception or customize the error message
            throw new CustomException("Erreur lors de l'ajout du test", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public TestDTO obtenirTestParId(Long idTest) {
        Optional<Test> testOptional = testRepository.findById(idTest);
        if (!testOptional.isPresent()) {
            throw new CustomException("Test avec " + idTest + " est introuvable", HttpStatus.NOT_FOUND);
        }
        return testMapper.toDTO(testOptional.get());
    }

    @Override
    public TestDTO modifierTest(Long idTest, TestDTO testDTO) {
        Optional<Test> existingTestOptional = testRepository.findById(idTest);

        if (!existingTestOptional.isPresent()) {
            throw new CustomException("Test avec " + idTest + " est introuvable", HttpStatus.NOT_FOUND);
        }

        Test existingTest = existingTestOptional.get();
        // Update fields as needed
        existingTest.setLabel(testDTO.getLabel());
        existingTest.setResultat(testDTO.getResultat());
        existingTest.setAnalyse(testDTO.getAnalyse());
        //existingTest.setTestType(testDTO.getTestType());
        existingTest.setStatutResultat(testDTO.getStatutResultat());


        Test updatedTest = testRepository.save(existingTest);
        return testMapper.toDTO(updatedTest);
    }

    @Override
    public void supprimerTest(Long idTest) {
        Optional<Test> testOptional = testRepository.findById(idTest);
        if (!testOptional.isPresent()) {
            throw new CustomException("Test avec " + idTest + " est introuvable", HttpStatus.NOT_FOUND);
        }
        testRepository.deleteById(idTest);
    }


    @Override


    public void determinerStatutResultat(TestDTO testDTO) {
        if (testDTO.getResultat() != null && testDTO.getTestType() != null) {
            if (testDTO.getResultat() >= testDTO.getTestType().getMin() && testDTO.getResultat() <= testDTO.getTestType().getMax()) {
                testDTO.setStatutResultat(StatutResultat.NORMAL);
            } else {
                testDTO.setStatutResultat(StatutResultat.ANORMAL);
            }


            testRepository.save(testMapper.toEntity(testDTO));
        }
    }
}

