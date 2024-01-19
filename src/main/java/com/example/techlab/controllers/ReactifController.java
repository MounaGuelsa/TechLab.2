package com.example.techlab.controllers;
import com.example.techlab.dto.PatientDTO;
import com.example.techlab.dto.ReactifDTO;
import com.example.techlab.dto.TestTypeDTO;
import com.example.techlab.services.ReactifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactifs")
public class ReactifController {

    private final ReactifService reactifService;
    @Autowired
    public ReactifController(ReactifService reactifService) {
        this.reactifService = reactifService;
    }
    @GetMapping
    public ResponseEntity<List<ReactifDTO>> listeReactifs() {
        List<ReactifDTO> reactifs = reactifService.listeReactifs();
        return new ResponseEntity<>(reactifs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReactifDTO> ajouterReactif(@RequestBody ReactifDTO reactifDTO) {
        ReactifDTO addedReactif = reactifService.ajouterReactif(reactifDTO);
        return new ResponseEntity<>(addedReactif, HttpStatus.CREATED);
    }
    @GetMapping("/{idReactif}")
    public ResponseEntity<ReactifDTO> obtenirReactifParId(@PathVariable Long idReactif) {
        ReactifDTO reactifDTO = reactifService.obtenirReactifParId(idReactif);
        return new ResponseEntity<>(reactifDTO,HttpStatus.OK);
    }
    @GetMapping("/reactifExpire")
    public ResponseEntity<List<ReactifDTO>> reactifExpire() {
        List<ReactifDTO> notificationReactifs = reactifService.reactifExpire();
        return new ResponseEntity<>(notificationReactifs, HttpStatus.OK);
    }
    @GetMapping("/reactifReptureStock")
    public ResponseEntity<List<ReactifDTO>> reactifReptureStock() {
        List<ReactifDTO> notificationReactifs = reactifService.reactifReptureEnStock();
        return new ResponseEntity<>(notificationReactifs, HttpStatus.OK);
    }
    @PutMapping("/{idReactif}")
    public ResponseEntity<ReactifDTO> modifierReactif(
            @PathVariable Long idReactif,
            @RequestBody ReactifDTO reactifDTO) {
        ReactifDTO updatedReactifDTO = reactifService.modifierReactif(idReactif, reactifDTO);
        return new ResponseEntity<>(updatedReactifDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{idReactif}")
    public ResponseEntity<Void> supprimerReactif(@PathVariable Long idReactif) {
        reactifService.supprimerReactif(idReactif);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
