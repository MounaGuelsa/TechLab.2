package com.example.techlab.mapper;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.entities.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PatientMapper extends GlobalMapper<PatientDTO, Patient> {
}