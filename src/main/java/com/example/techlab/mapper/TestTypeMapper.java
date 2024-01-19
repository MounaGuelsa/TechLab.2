package com.example.techlab.mapper;

import com.example.techlab.dto.TestTypeDTO;
import com.example.techlab.entities.TestType;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")

public interface TestTypeMapper extends GlobalMapper<TestTypeDTO, TestType>{}