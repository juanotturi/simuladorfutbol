package com.project.simuladorfutbol.service;

import com.project.simuladorfutbol.model.ProbabilityMatrix;
import org.springframework.stereotype.Service;

@Service
public class ProbabilityService {

    private final ProbabilityMatrix probabilityMatrix;

    public ProbabilityService(ProbabilityMatrix probabilityMatrix) {
        this.probabilityMatrix = probabilityMatrix;
    }

    /**
     * Devuelve el índice del vector de probabilidad dado el score de A y B.
     * @param scoreA Puntaje del equipo A
     * @param scoreB Puntaje del equipo B
     * @return índice del vector (-17 a +17)
     */
    public int getVectorIndex(int scoreA, int scoreB) {
        return probabilityMatrix.getVectorValue(scoreA, scoreB);
    }
}
