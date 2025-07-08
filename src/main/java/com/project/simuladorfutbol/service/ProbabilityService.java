package com.project.simuladorfutbol.service;

import com.project.simuladorfutbol.dto.ExactResultDTO;
import com.project.simuladorfutbol.dto.ProbabilityVectorDTO;
import com.project.simuladorfutbol.model.ExactResultMatrix;
import com.project.simuladorfutbol.model.ProbabilityMatrix;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProbabilityService {

    private final ProbabilityMatrix matrix;
    private final ProbabilityVectorMapper mapper;
    private final ExactResultMatrix exactResultMatrix;
    private final ExactResultMapper exactResultCodeMapper;
    private final Random random = new Random();

    public ProbabilityService(ProbabilityMatrix matrix, ProbabilityVectorMapper mapper, ExactResultMatrix exactResultMatrix, ExactResultMapper exactResultCodeMapper) {
        this.matrix = matrix;
        this.mapper = mapper;
        this.exactResultMatrix = exactResultMatrix;
        this.exactResultCodeMapper = exactResultCodeMapper;
    }

    public ExactResultDTO simulateMatch(int scoreA, int scoreB) {
        int vectorIndex = getVectorIndex(scoreA, scoreB);

        if (Math.abs(scoreA - scoreB) == 1) {
            vectorIndex = 0;
        }

        int rand = random.nextInt(100) + 1;
        int resultCode = exactResultMatrix.getResultCode(vectorIndex, rand);

        return exactResultCodeMapper.getResult(resultCode);
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
