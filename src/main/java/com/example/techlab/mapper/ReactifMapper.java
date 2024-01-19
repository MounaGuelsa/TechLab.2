package com.example.techlab.mapper;

import com.example.techlab.dto.PatientDTO;
import com.example.techlab.dto.ReactifDTO;
import com.example.techlab.entities.Patient;
import com.example.techlab.entities.Reactif;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")

public interface ReactifMapper extends GlobalMapper<ReactifDTO, Reactif>{
}
