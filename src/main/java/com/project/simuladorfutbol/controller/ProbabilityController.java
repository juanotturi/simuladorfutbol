package com.project.simuladorfutbol.controller;

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
     * Endpoint de prueba
     * Ejemplo de uso: /calculateVectorIndex?scoreA=85&scoreB=72
     * Devuelve en JSON: { "vectorIndex": 6 }
     */
    @GetMapping("/calculateVectorIndex")
    public Map<String, Integer> getVectorIndex(@RequestParam int scoreA, @RequestParam int scoreB) {
        int vector = probabilityService.getVectorIndex(scoreA, scoreB);
        return Map.of("vectorIndex", vector);
    }
}
