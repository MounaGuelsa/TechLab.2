package com.example.techlab.controllers;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.dto.TestDTO;
import com.example.techlab.services.AnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analyses")
public class AnalyseController {

    private final AnalyseService analyseService;

    @Autowired
    public AnalyseController(AnalyseService analyseService) {
        this.analyseService = analyseService;
    }

    @GetMapping
    public ResponseEntity<List<AnalyseDTO>> obtenirAnalyses() {
        List<AnalyseDTO> analyses = analyseService.obtenirAnalyses();
        return new ResponseEntity<>(analyses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AnalyseDTO> ajouterAnalyse(@RequestBody AnalyseDTO analyseDTO) {
        AnalyseDTO addedAnalyse = analyseService.ajouterAnalyse(analyseDTO);
        return new ResponseEntity<>(addedAnalyse, HttpStatus.CREATED);
    }

    @GetMapping("/{idAnalyse}")
    public ResponseEntity<AnalyseDTO> obtenirAnalyseParId(@PathVariable Long idAnalyse) {
        AnalyseDTO analyseDTO = analyseService.obtenirAnalyseParId(idAnalyse);
        return new ResponseEntity<>(analyseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{idAnalyse}")
    public ResponseEntity<Void> supprimerAnalyse(@PathVariable Long idAnalyse) {
        analyseService.supprimerAnalyse(idAnalyse);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idAnalyse}")
    public ResponseEntity<AnalyseDTO> modifierAnalyse(
            @PathVariable Long idAnalyse,
            @RequestBody AnalyseDTO analyseDTO) {
        AnalyseDTO updatedAnalyseDTO = analyseService.modifierAnalyse(idAnalyse, analyseDTO);
        return new ResponseEntity<>(updatedAnalyseDTO, HttpStatus.OK);
    }

    @GetMapping("/en-cours")
    public ResponseEntity<List<AnalyseDTO>> obtenirAnalysesEnCours() {
        List<AnalyseDTO> analysesEnCours = analyseService.obtenirAnalysesEnCours();
        return new ResponseEntity<>(analysesEnCours, HttpStatus.OK);
        //5
    }

    @GetMapping("/{idAnalyse}/resultats")
    public ResponseEntity<List<TestDTO>> obtenirResultatAnalyse(@PathVariable Long idAnalyse) {
        List<TestDTO> resultatAnalyse = analyseService.obtenirResulatAnalyse(idAnalyse);
        return new ResponseEntity<>(resultatAnalyse, HttpStatus.OK);
    }
}
