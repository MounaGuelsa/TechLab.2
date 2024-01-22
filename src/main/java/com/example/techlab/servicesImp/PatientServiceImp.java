package com.example.techlab.servicesImp;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Patient;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.mapper.PatientMapper;
import com.example.techlab.repositories.PatientRepository;
import com.example.techlab.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Patient> patientOptional = patientRepository.findById(idPatient);
        if (!patientOptional.isPresent()) {
            throw new CustomException("patient avec "+idPatient+"  est introuvable ", HttpStatus.NOT_FOUND);
        } else {
            PatientDTO patientDTO = patientMapper.toDTO(patientOptional.get());
            return patientDTO;
        }
    }

    @Override
    public PatientDTO modifierPatient(Long idPatient, PatientDTO patientDTO) {

        Optional<Patient> existingPatientOptional = patientRepository.findById(idPatient);

        if (!existingPatientOptional.isPresent()) {
            throw new CustomException("Patient avec " + idPatient + " est introuvable", HttpStatus.NOT_FOUND);
        }

        Patient existingPatient = existingPatientOptional.get();

        existingPatient.setNom(patientDTO.getNom());
        existingPatient.setPrenom(patientDTO.getPrenom());
        existingPatient.setSexe(patientDTO.getSexe());
        existingPatient.setAdresse(patientDTO.getAdresse());
        existingPatient.setTelephone(patientDTO.getTelephone());
        existingPatient.setDdn(patientDTO.getDdn());

        Patient updatedUpdated = patientRepository.save(existingPatient);

        return patientMapper.toDTO(updatedUpdated);
    }

    @Override
    public void supprimerPatient(Long idPatient) {
        Optional<Patient> patientOptional = patientRepository.findById(idPatient);
        if (!patientOptional.isPresent()) {
            throw new CustomException("patient avec "+idPatient+" est introuvable", HttpStatus.NOT_FOUND);
        } else {
            patientRepository.deleteById(idPatient);;

        }
    }

    @Override
    public List<Analyse> HistoriqueAnalyses(Long patientDTO) {
        Optional<Patient> patientOptional = patientRepository.findById(patientDTO);
        if (!patientOptional.isPresent()) {
            throw new CustomException("Patient avec l'ID " + patientDTO + " introuvable", HttpStatus.NOT_FOUND);
        }
        Patient patient = patientOptional.get();
        List<Analyse> historiqueAnalyses = patient.getAnalyses();
        return historiqueAnalyses;
    }
}
