package com.project.simuladorfutbol.controller;

import com.project.simuladorfutbol.dto.PlayerDTO;
import com.project.simuladorfutbol.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService service) {
        this.playerService = service;
    }

    @GetMapping
    public List<PlayerDTO> all() {
        return playerService.findAll();
    }

    @GetMapping("/team/{teamId}")
    public List<PlayerDTO> byTeam(@PathVariable long teamId) {
        return playerService.findByTeam(teamId);
    }

    /** Opcional: pedir al backend un autor aleatorio ya resuelto. */
    @GetMapping("/team/{teamId}/random-scorer")
    public PlayerDTO randomScorer(@PathVariable long teamId) {
        return playerService.pickRandomScorer(teamId);
    }
}
