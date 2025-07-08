package com.project.simuladorfutbol.controller;

import com.project.simuladorfutbol.dto.ExactResultDTO;
import com.project.simuladorfutbol.dto.ProbabilityVectorDTO;
import com.project.simuladorfutbol.service.ProbabilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProbabilityController {

    private final ProbabilityService probabilityService;

    public ProbabilityController(ProbabilityService probabilityService) {
        this.probabilityService = probabilityService;
    }

    /**
     * Ejemplo de uso: /simulateMatch?scoreA=84&scoreB=63
     * Devuelve en JSON: {
     *   "goalsTeamA": 2,
     *   "goalsTeamB": 1
     * }
     */
    @GetMapping("/simulateMatch")
    public ExactResultDTO simulateMatch(@RequestParam int scoreA, @RequestParam int scoreB) {
        return probabilityService.simulateMatch(scoreA, scoreB);
    }

    /**
     * Ejemplo de uso: /getProbabilityVector?scoreA=84&scoreB=63
     * Devuelve en JSON: {
     *   "probabilityTeamA": 82,
     *   "probabilityDraw": 11,
     *   "probabilityTeamB": 7
     * }
     */
    @GetMapping("/getProbabilityVector")
    public ProbabilityVectorDTO getProbabilityVector(@RequestParam int scoreA, @RequestParam int scoreB) {
        return probabilityService.getProbabilityVector(scoreA, scoreB);
    }

    /**
     * Ejemplo de uso: /calculateVectorIndex?scoreA=85&scoreB=76
     * Devuelve en JSON: { "vectorIndex": 6 }
     */
    @GetMapping("/calculateVectorIndex")
    public Map<String, Integer> getVectorIndex(@RequestParam int scoreA, @RequestParam int scoreB) {
        int vector = probabilityService.getVectorIndex(scoreA, scoreB);
        return Map.of("vectorIndex", vector);
    }
}
