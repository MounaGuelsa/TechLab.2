package com.example.techlab.mapper;


import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface PatientMapper extends GlobalMapper<PatientDTO, Patient> {

    @Mapping(target = "analysesDTO",source ="analyses")
    PatientDTO toDTO(Patient patient);
    @Mapping(target="analyses",source = "analysesDTO")
    Patient toEntity(PatientDTO patientDTO);
}