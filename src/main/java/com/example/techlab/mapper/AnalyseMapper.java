package com.example.techlab.mapper;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.entities.Analyse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface AnalyseMapper {
    @Mapping(target = "testsListDTO",source ="testsList")
    @Mapping(target = "technicienDTO",source ="technicien")
    @Mapping(target = "echantillonDTO",source ="echantillon")

    AnalyseDTO toDTO(Analyse analyse);
    @Mapping(target="testsList",source = "testsListDTO")
    @Mapping(target = "technicien",source ="technicienDTO")
    @Mapping(target = "echantillon",source ="echantillonDTO")
    Analyse toEntity(AnalyseDTO analyseDTO);

}
