package com.project.simuladorfutbol.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProbabilityVectorDTO {
    private int probabilityTeamA;
    private int probabilityDraw;
    private int probabilityTeamB;

    // Constructor con parámetros
    public ProbabilityVectorDTO(int probabilityTeamA, int probabilityDraw, int probabilityTeamB) {
        this.probabilityTeamA = probabilityTeamA;
        this.probabilityDraw = probabilityDraw;
        this.probabilityTeamB = probabilityTeamB;
    }

    public int getProbabilityTeamA() {
        return probabilityTeamA;
    }

    public void setProbabilityTeamA(int probabilityTeamA) {
        this.probabilityTeamA = probabilityTeamA;
    }

    public int getProbabilityDraw() {
        return probabilityDraw;
    }

    public void setProbabilityDraw(int probabilityDraw) {
        this.probabilityDraw = probabilityDraw;
    }

    public int getProbabilityTeamB() {
        return probabilityTeamB;
    }

    public void setProbabilityTeamB(int probabilityTeamB) {
        this.probabilityTeamB = probabilityTeamB;
    }
}
