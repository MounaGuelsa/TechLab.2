package com.example.techlab.mapper;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.entities.Analyse;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface AnalyseMapper extends GlobalMapper<AnalyseDTO, Analyse>{
}
