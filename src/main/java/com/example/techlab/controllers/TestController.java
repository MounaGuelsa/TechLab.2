package com.example.techlab.controllers;

import com.example.techlab.dto.TestDTO;
import com.example.techlab.dto.TestTypeDTO;
import com.example.techlab.services.TestService;
import com.example.techlab.services.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {
    private final TestService testService;
    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;

    }
    @GetMapping
    public ResponseEntity<List<TestDTO>> listeTest() {
        List<TestDTO> tests = testService.listeTest();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TestDTO> ajouterTestType(@RequestBody TestDTO testDTO) {
        TestDTO addedTest = testService.ajouterTest(testDTO);
        testService.determinerStatutResultat(addedTest);
        return new ResponseEntity<>(addedTest, HttpStatus.CREATED);
    }
    @GetMapping("/{idTest}")
    public ResponseEntity<TestDTO> obtenirTestParId(@PathVariable Long idTest) {
        TestDTO testDTO = testService.obtenirTestParId(idTest);
        return new ResponseEntity<>(testDTO,HttpStatus.OK);
    }
    @PutMapping("/{idTest}")
    public ResponseEntity<TestDTO> modifierTest(
            @PathVariable Long idTest,
            @RequestBody TestDTO testDTO) {
        TestDTO updatedTypeDTO = testService.modifierTest(idTest,testDTO);
        return new ResponseEntity<>(updatedTypeDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{idTest}")
    public ResponseEntity<Void> supprimerTest(@PathVariable Long idTest) {
        testService.supprimerTest(idTest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
