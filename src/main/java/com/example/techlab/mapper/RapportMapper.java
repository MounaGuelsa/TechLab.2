package com.example.techlab.mapper;

import com.example.techlab.dto.RapportDTO;
import com.example.techlab.entities.Rapport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RapportMapper extends GlobalMapper<RapportDTO, Rapport> {
}
