package com.example.techlab.mapper;

import com.example.techlab.dto.AnalyseDTO;
import com.example.techlab.dto.TestDTO;
import com.example.techlab.entities.Analyse;
import com.example.techlab.entities.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface TestMapper  {
    @Mapping(target = "testTypeDTO",source ="testType")

    TestDTO toDTO(Test test);
    @Mapping(target="testType",source = "testTypeDTO")

    Test toEntity(TestDTO testDTO);

}
