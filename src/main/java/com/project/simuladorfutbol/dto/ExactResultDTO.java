package com.project.simuladorfutbol.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExactResultDTO {
    private int goalsTeamA;
    private int goalsTeamB;

    public ExactResultDTO(int goalsTeamA, int goalsTeamB) {
        this.goalsTeamA = goalsTeamA;
        this.goalsTeamB = goalsTeamB;
    }

    public int getGoalsTeamA() {
        return goalsTeamA;
    }

    public void setGoalsTeamA(int goalsTeamA) {
        this.goalsTeamA = goalsTeamA;
    }

    public int getGoalsTeamB() {
        return goalsTeamB;
    }

    public void setGoalsTeamB(int goalsTeamB) {
        this.goalsTeamB = goalsTeamB;
    }
}
