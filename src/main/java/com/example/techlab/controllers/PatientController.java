package com.example.techlab.controllers;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> obtenirPatients() {
        List<PatientDTO> patients = patientService.obtenirPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> ajouterPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO addedPatient = patientService.ajouterPatient(patientDTO);
        return new ResponseEntity<>(addedPatient, HttpStatus.CREATED);
    }

    @GetMapping("/{idPatient}")
    public ResponseEntity<PatientDTO> obtenirPatientParId(@PathVariable Long idPatient) {
        PatientDTO patientDTO = patientService.obtenirPatientParId(idPatient);
        return new ResponseEntity<>(patientDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{idPatient}")
    public ResponseEntity<Void> supprimerPatient(@PathVariable Long idPatient) {
        patientService.supprimerPatient(idPatient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/{idPatient}/analyses")
//    public ResponseEntity<List<Analyse>> obtenirAnalysesParPatient(@PathVariable Long idPatient) {
//        // You can implement the logic to obtain analyses based on the patient ID here
//        // For now, returning an empty list
//        List<Analyse> analyses = patientService.obtenirAnalysesParPatient(idPatient);
//        return new ResponseEntity<>(analyses, HttpStatus.OK);
//    }
}
