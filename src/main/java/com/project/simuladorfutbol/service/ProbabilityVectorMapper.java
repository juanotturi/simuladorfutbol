package com.project.simuladorfutbol.service;

import com.project.simuladorfutbol.dto.ProbabilityVectorDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProbabilityVectorMapper {

    private final Map<Integer, ProbabilityVectorDTO> map;

    public ProbabilityVectorMapper() {
        this.map = new HashMap<>();
        initializeMap();
    }

    private void initializeMap() {
        map.put(17, new ProbabilityVectorDTO(97, 2, 1));
        map.put(16, new ProbabilityVectorDTO(95, 3, 2));
        map.put(15, new ProbabilityVectorDTO(90, 6, 4));
        map.put(14, new ProbabilityVectorDTO(86, 9, 5));
        map.put(13, new ProbabilityVectorDTO(82, 11, 7));
        map.put(12, new ProbabilityVectorDTO(78, 14, 8));
        map.put(11, new ProbabilityVectorDTO(74, 17, 9));
        map.put(10, new ProbabilityVectorDTO(70, 20, 10));
        map.put(9, new ProbabilityVectorDTO(66, 22, 12));
        map.put(8, new ProbabilityVectorDTO(62, 24, 14));
        map.put(7, new ProbabilityVectorDTO(58, 26, 16));
        map.put(6, new ProbabilityVectorDTO(54, 28, 18));
        map.put(5, new ProbabilityVectorDTO(50, 30, 20));
        map.put(4, new ProbabilityVectorDTO(46, 32, 22));
        map.put(3, new ProbabilityVectorDTO(42, 34, 24));
        map.put(2, new ProbabilityVectorDTO(38, 36, 26));
        map.put(1, new ProbabilityVectorDTO(34, 38, 28));
        map.put(0, new ProbabilityVectorDTO(30, 40, 30));
        map.put(-1, new ProbabilityVectorDTO(28, 38, 34));
        map.put(-2, new ProbabilityVectorDTO(26, 36, 38));
        map.put(-3, new ProbabilityVectorDTO(24, 34, 42));
        map.put(-4, new ProbabilityVectorDTO(22, 32, 46));
        map.put(-5, new ProbabilityVectorDTO(20, 30, 50));
        map.put(-6, new ProbabilityVectorDTO(18, 28, 54));
        map.put(-7, new ProbabilityVectorDTO(16, 26, 58));
        map.put(-8, new ProbabilityVectorDTO(14, 24, 62));
        map.put(-9, new ProbabilityVectorDTO(12, 22, 66));
        map.put(-10, new ProbabilityVectorDTO(10, 20, 70));
        map.put(-11, new ProbabilityVectorDTO(9, 17, 74));
        map.put(-12, new ProbabilityVectorDTO(8, 14, 78));
        map.put(-13, new ProbabilityVectorDTO(7, 11, 82));
        map.put(-14, new ProbabilityVectorDTO(5, 9, 86));
        map.put(-15, new ProbabilityVectorDTO(4, 6, 90));
        map.put(-16, new ProbabilityVectorDTO(2, 3, 95));
        map.put(-17, new ProbabilityVectorDTO(1, 2, 97));
    }

    public ProbabilityVectorDTO getVector(int index) {
        return map.getOrDefault(index, new ProbabilityVectorDTO(30, 40, 30));
    }
}
