package com.example.techlab.mapper;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.dto.PlanificationDTO;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.Planification;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")

public interface PlanificationMapper extends GlobalMapper<PlanificationDTO, Planification> {
}
