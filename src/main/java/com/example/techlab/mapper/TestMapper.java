package com.example.techlab.mapper;

import com.example.techlab.dto.TestDTO;
import com.example.techlab.entities.Test;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface TestMapper extends GlobalMapper<TestDTO, Test> {
}
