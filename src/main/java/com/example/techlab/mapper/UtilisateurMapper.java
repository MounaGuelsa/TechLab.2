package com.example.techlab.mapper;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.dto.UtilisateurDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    @Mapping(target = "analysesDTO",source ="analyses")
    UtilisateurDTO toDTO(Utilisateur utilisateur);

    @Mapping(target = "analyses",source ="analysesDTO")
    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);
}
