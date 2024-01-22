package com.example.techlab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanificationDTO {
    private Date dateDebut;
    private Date dateFin;
}
