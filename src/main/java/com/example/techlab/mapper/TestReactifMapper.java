package com.example.techlab.mapper;

import com.example.techlab.dto.TestReactifDTO;
import com.example.techlab.entities.TestReactif;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface TestReactifMapper extends GlobalMapper<TestReactifDTO, TestReactif> {
}
