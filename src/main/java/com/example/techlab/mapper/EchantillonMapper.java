package com.example.techlab.mapper;


import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Echantillon;
import com.example.techlab.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface EchantillonMapper {
    @Mapping(target = "analysesListDTO",source ="analysesList")
    @Mapping(target = "patientTO",source ="patient")
    EchantillonDTO toDTO(Echantillon echantillon);
    @Mapping(target="analysesList",source = "analysesListDTO")
    @Mapping(target="patient",source = "patientDTO")
    Echantillon toEntity(EchantillonDTO echantillonDTO);
}
