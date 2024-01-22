package com.example.techlab.controllers;

import com.example.techlab.dto.PlanificationDTO;
import com.example.techlab.services.PlanificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planifications")
public class PlanificationController {

    private final PlanificationService planificationService;

    @Autowired
    public PlanificationController(PlanificationService planificationService) {
        this.planificationService = planificationService;
    }

    @GetMapping
    public ResponseEntity<List<PlanificationDTO>> listePlanifications() {
        List<PlanificationDTO> planifications = planificationService.listePlanifications();
        return new ResponseEntity<>(planifications, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlanificationDTO> planifierAnalyse(@RequestBody PlanificationDTO planificationDTO) {
        PlanificationDTO planification = planificationService.planifierAnalyse(planificationDTO);
        return new ResponseEntity<>(planification, HttpStatus.CREATED);
    }

    @GetMapping("/{idPlanification}")
    public ResponseEntity<PlanificationDTO> obtenirPlanificationParId(@PathVariable Long idPlanification) {
        PlanificationDTO planificationDTO = planificationService.obtenirPlanificationParId(idPlanification);
        return new ResponseEntity<>(planificationDTO, HttpStatus.OK);
    }

    @PutMapping("/{idPlanification}")
    public ResponseEntity<PlanificationDTO> modifierPlanification(
            @PathVariable Long idPlanification,
            @RequestBody PlanificationDTO planificationDTO) {
        PlanificationDTO updatedPlanificationDTO = planificationService.modifierPlanification(idPlanification, planificationDTO);
        return new ResponseEntity<>(updatedPlanificationDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{idPlanification}")
    public ResponseEntity<Void> supprimerPlanification(@PathVariable Long idPlanification) {
        planificationService.supprimerPlanification(idPlanification);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
