package com.example.techlab.controllers;

import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.services.EchantillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/echantillons")
public class EchantillonController {
    private final EchantillonService echantillonService;
    @Autowired
    public EchantillonController(EchantillonService echantillonService) {
        this.echantillonService = echantillonService;
    }


    @GetMapping
    public ResponseEntity<List<EchantillonDTO>> obtenirEchantillons() {
        List<EchantillonDTO> echantillons = echantillonService.obtenirEchantillons();
        return new ResponseEntity<>(echantillons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EchantillonDTO> ajouterEchantillon(@RequestBody EchantillonDTO echantillonDTO) {
        EchantillonDTO addedEchantillon = echantillonService.ajouterEchantillon(echantillonDTO);
        return new ResponseEntity<>(addedEchantillon, HttpStatus.CREATED);
    }

    @GetMapping("/{idEchantillon}")
    public ResponseEntity<EchantillonDTO> obtenirEchantillonParId(@PathVariable Long idEchantillon) {
        EchantillonDTO echantillonDTO  = echantillonService.obtenirEchantillonParId(idEchantillon);
        return new ResponseEntity<>(echantillonDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{idEchantillon}")
    public ResponseEntity<Void> supprimerEchantillon(@PathVariable Long idEchantillon) {
        echantillonService.supprimerEchantillon(idEchantillon);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{idEchantillon}")
    public ResponseEntity<EchantillonDTO> modifierEchantillon(
            @PathVariable Long idEchantillon,
            @RequestBody EchantillonDTO echantillonDTO) {
        EchantillonDTO updatedEchantillonDTO = echantillonService.modifierEchantillon(idEchantillon, echantillonDTO);
        return new ResponseEntity<>(updatedEchantillonDTO, HttpStatus.OK);
    }
}
