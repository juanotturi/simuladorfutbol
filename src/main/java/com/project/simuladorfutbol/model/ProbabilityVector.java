package com.project.simuladorfutbol.model;

public class ProbabilityVector {
    private final int winPercentage;
    private final int drawPercentage;
    private final int losePercentage;

    public ProbabilityVector(int winPercentage, int drawPercentage, int losePercentage) {
        this.winPercentage = winPercentage;
        this.drawPercentage = drawPercentage;
        this.losePercentage = losePercentage;
    }

    public int getWinPercentage() {
        return winPercentage;
    }

    public int getDrawPercentage() {
        return drawPercentage;
    }

    public int getLosePercentage() {
        return losePercentage;
    }

    @Override
    public String toString() {
        return winPercentage + "-" + drawPercentage + "-" + losePercentage;
    }
}
