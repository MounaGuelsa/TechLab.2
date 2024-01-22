package com.example.techlab.mapper;


import com.example.techlab.dto.EchantillonDTO;
import com.example.techlab.entities.Echantillon;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EchantillonMapper extends GlobalMapper<EchantillonDTO, Echantillon>{
}
