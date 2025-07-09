package com.project.simuladorfutbol.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.simuladorfutbol.dto.TeamDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private final List<TeamDTO> teams = new ArrayList<>();

    @PostConstruct
    public void loadTeams() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream("teams.json");
            if (is != null) {
                List<TeamDTO> loaded = mapper.readValue(is, new TypeReference<List<TeamDTO>>() {});
                teams.addAll(loaded);
            } else {
                throw new IllegalStateException("No se encontró el archivo teams.json");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error cargando teams.json", e);
        }
    }

    public List<TeamDTO> getAllTeams() {
        return teams;
    }

    public TeamDTO getTeamById(long id) {
        return teams.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
