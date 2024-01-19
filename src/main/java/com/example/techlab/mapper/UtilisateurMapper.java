package com.example.techlab.mapper;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.dto.UtilisateurDTO;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.Utilisateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper extends GlobalMapper<UtilisateurDTO, Utilisateur> {
}
