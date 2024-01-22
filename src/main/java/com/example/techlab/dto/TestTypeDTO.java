package com.example.techlab.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestTypeDTO {
    private long id;
    private String nomTest;
    private double max;
    private double min;
    private String unite;
}
