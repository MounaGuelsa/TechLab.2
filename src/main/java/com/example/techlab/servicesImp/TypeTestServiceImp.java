package com.example.techlab.servicesImp;

import com.example.techlab.dto.TestTypeDTO;
import com.example.techlab.entities.TestType;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.TestTypeMapper;
import com.example.techlab.repositories.TestTypeRepository;
import com.example.techlab.services.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class TypeTestServiceImp implements TestTypeService {
    private final TestTypeRepository testTypeRepository;
    private final TestTypeMapper testTypeMapper;

    @Autowired
    public TypeTestServiceImp(TestTypeRepository testTypeRepository, TestTypeMapper testTypeMapper) {
        this.testTypeRepository = testTypeRepository;
        this.testTypeMapper = testTypeMapper;
    }
    @Override
    public List<TestTypeDTO> listeTestType() {
        return testTypeRepository.findAll().stream()
                .map(testTypeMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public TestTypeDTO ajouterTestType(TestTypeDTO testTypeDTO) {
        try {
            TestType testType = testTypeMapper.toEntity(testTypeDTO);
            testTypeRepository.save(testType);

            return testTypeMapper.toDTO(testType);

        } catch (
                Exception e) {
            throw new CustomException("Erreur lors de l'ajout du testType", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @Override
    public TestTypeDTO obtenirTestTypeParId(Long idTestType) {
        Optional<TestType> testTypeOptional = testTypeRepository.findById(idTestType);
        if (!testTypeOptional.isPresent()) {
            throw new CustomException("TestType avec " + idTestType + "  est introuvable ", HttpStatus.NOT_FOUND);
        }
        return testTypeMapper.toDTO(testTypeOptional.get());
    }
    @Override
    public TestTypeDTO modifierTestType(Long idTestType, TestTypeDTO testTypeDTO) {
        Optional<TestType> existingTestTypeOptional = testTypeRepository.findById(idTestType);

        if (!existingTestTypeOptional.isPresent()) {
            throw new CustomException("TestType avec " + idTestType + " est introuvable", HttpStatus.NOT_FOUND);
        }

        TestType existingTestType = existingTestTypeOptional.get();
        existingTestType.setNomTest(testTypeDTO.getNomTest());
        existingTestType.setMax(testTypeDTO.getMax());
        existingTestType.setMin(testTypeDTO.getMin());
        existingTestType.setUnite(testTypeDTO.getUnite());
        TestType updatedTestType = testTypeRepository.save(existingTestType);
        return testTypeMapper.toDTO(updatedTestType);
    }
    @Override
    public void supprimerTestType(Long idTestType) {
        Optional<TestType> testTypeOptional = testTypeRepository.findById(idTestType);
        if (!testTypeOptional.isPresent()) {
            throw new CustomException("TestType avec " + idTestType + "  est introuvable ", HttpStatus.NOT_FOUND);

        }
        testTypeRepository.deleteById(idTestType);
    }
}
