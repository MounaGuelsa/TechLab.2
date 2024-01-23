package com.example.techlab.services;

import com.example.techlab.dto.PatientDTO;
//import com.example.techlab.dto.PlanificationDTO;
import com.example.techlab.entities.Analyse;

import java.util.List;

public interface PatientService {
    public List<PatientDTO> obtenirPatients();

    public PatientDTO ajouterPatient(PatientDTO patientDTO);

    public PatientDTO obtenirPatientParId(Long idPatient);

    public PatientDTO modifierPatient(Long idPatient, PatientDTO patientDTO);


    public void supprimerPatient(Long idPatient);

    public List<Analyse>  HistoriqueAnalyses(Long patientDTO);


}
