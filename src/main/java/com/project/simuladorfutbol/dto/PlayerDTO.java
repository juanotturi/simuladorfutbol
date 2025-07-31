package com.project.simuladorfutbol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private long id;
    private long idTeam;
    private String name;
    private int goalProbability;
    private String position;
}
