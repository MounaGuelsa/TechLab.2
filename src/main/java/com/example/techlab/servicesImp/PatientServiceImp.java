package com.example.techlab.servicesImp;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Patient;
import com.example.techlab.mapper.PatientMapper;
import com.example.techlab.repositories.PatientRepository;
import com.example.techlab.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImp implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    @Autowired
    public PatientServiceImp(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }
    @Override
    public List<PatientDTO> obtenirPatients() {
        List<PatientDTO> patients = patientRepository.findAll().stream()
                .map(patientMapper::toDTO)
                .collect(Collectors.toList());
        return patients;
    }
    @Override
    public PatientDTO ajouterPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO);
        patientRepository.save(patient);
        return patientMapper.toDTO(patient);
    }
    @Override
    public PatientDTO obtenirPatientParId(Long idPatient) {
        return patientRepository.findById(idPatient)
                .map(patientMapper::toDTO)
                .orElse(null);
    }
    @Override
    public void supprimerPatient(Long idPatient) {
        patientRepository.deleteById(idPatient);
    }
    @Override
    public List<Analyse> obtenirAnalysesParPatient(PatientDTO patientDTO) {
        return null;
    }
}
