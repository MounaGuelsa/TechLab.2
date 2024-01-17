package com.example.techlab.mapper;

public interface GlobalMapper <DTO,ENTITY>{
    DTO toDTO(ENTITY e);
    ENTITY toEntity(DTO o);
}
