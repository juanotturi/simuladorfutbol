package com.project.simuladorfutbol.service;

import com.project.simuladorfutbol.dto.ProbabilityVectorDTO;
import com.project.simuladorfutbol.model.ProbabilityMatrix;
import org.springframework.stereotype.Service;

@Service
public class ProbabilityService {

    private final ProbabilityMatrix matrix;
    private final ProbabilityVectorMapper mapper;

    public ProbabilityService(ProbabilityMatrix matrix, ProbabilityVectorMapper mapper) {
        this.matrix = matrix;
        this.mapper = mapper;
    }

    public ProbabilityVectorDTO getProbabilityVector(int scoreA, int scoreB) {
        int index = matrix.getVectorValue(scoreA, scoreB);
        return mapper.getVector(index);
    }

    /**
     * Devuelve el índice del vector de probabilidad dado el score de A y B.
     * @param scoreA Puntaje del equipo A
     * @param scoreB Puntaje del equipo B
     * @return índice del vector (-17 a +17)
     */
    public int getVectorIndex(int scoreA, int scoreB) {
        return matrix.getVectorValue(scoreA, scoreB);
    }
}
