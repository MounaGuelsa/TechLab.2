package com.example.techlab.controllers;

import com.example.techlab.dto.TestTypeDTO;
import com.example.techlab.services.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testType")
public class TestTypeController {
    private final TestTypeService testTypeService;
    @Autowired
    public TestTypeController(TestTypeService testTypeService) {
        this.testTypeService = testTypeService;

    }
    @GetMapping
    public ResponseEntity<List<TestTypeDTO>> listeTestTypes() {
        List<TestTypeDTO> testTypes = testTypeService.listeTestType();
        return new ResponseEntity<>(testTypes, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TestTypeDTO> ajouterTestType(@RequestBody TestTypeDTO testTypeDTO) {
        TestTypeDTO addedTestType = testTypeService.ajouterTestType(testTypeDTO);
        return new ResponseEntity<>(addedTestType, HttpStatus.CREATED);
    }
    @GetMapping("/{idTestType}")
    public ResponseEntity<TestTypeDTO> obtenirTestTypeParId(@PathVariable Long idTestType) {
        TestTypeDTO testTypeDTO = testTypeService.obtenirTestTypeParId(idTestType);
        return new ResponseEntity<>(testTypeDTO,HttpStatus.OK);
    }
    @PutMapping("/{idTestType}")
    public ResponseEntity<TestTypeDTO> modifierTestType(
            @PathVariable Long idTestType,
            @RequestBody TestTypeDTO testTypeDTO) {
        TestTypeDTO updatedTestTypeDTO = testTypeService.modifierTestType(idTestType, testTypeDTO);
        return new ResponseEntity<>(updatedTestTypeDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{idTestType}")
    public ResponseEntity<Void> supprimerTestType(@PathVariable Long idTestType) {
        testTypeService.supprimerTestType(idTestType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
