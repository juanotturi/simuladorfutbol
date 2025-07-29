package com.project.simuladorfutbol.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.simuladorfutbol.dto.PlayerDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final ObjectMapper mapper = new ObjectMapper();
    private List<PlayerDTO> allPlayers = List.of();
    private final Map<Long, List<PlayerDTO>> byTeam = new ConcurrentHashMap<>();

    @PostConstruct
    public void load() {
        try (InputStream is = new ClassPathResource("players.json").getInputStream()) {
            allPlayers = mapper.readValue(is, new TypeReference<List<PlayerDTO>>() {});
            allPlayers.forEach(p -> {
                if (p.getGoalProbability() < 0) p.setGoalProbability(0);
            });
            Map<Long, List<PlayerDTO>> grouped = allPlayers.stream()
                    .collect(Collectors.groupingBy(PlayerDTO::getIdTeam));
            byTeam.clear();
            byTeam.putAll(grouped);
        } catch (Exception e) {
            allPlayers = List.of();
            byTeam.clear();
        }
    }

    public List<PlayerDTO> findAll() {
        return allPlayers;
    }

    public List<PlayerDTO> findByTeam(long teamId) {
        return byTeam.getOrDefault(teamId, List.of());
    }

    public PlayerDTO pickRandomScorer(long teamId) {
        List<PlayerDTO> players = byTeam.get(teamId);
        if (players == null || players.isEmpty()) return null;

        int total = players.stream().mapToInt(p -> Math.max(0, p.getGoalProbability())).sum();
        if (total <= 0) {
            int idx = (int) (Math.random() * players.size());
            return players.get(idx);
        }

        double r = Math.random() * total;
        for (PlayerDTO p : players) {
            r -= Math.max(0, p.getGoalProbability());
            if (r < 0) return p;
        }
        return players.get(players.size() - 1);
    }
}
