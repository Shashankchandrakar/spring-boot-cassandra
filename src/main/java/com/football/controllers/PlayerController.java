package com.football.controllers;

import com.football.pojo.Player;
import com.football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/player/")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") UUID id){
        return playerService.getPlayerById(id);
    }

    @PostMapping("/create")
    public Player createPlayer(@RequestBody Player player){
        return playerService.createPlayer(player);
    }

    @DeleteMapping("/delete/{playerId}")
    public void deletePlayer(@PathVariable("playerId") UUID id){
        playerService.deletePlayer(id);
    }

    @PutMapping("/update/{playerId}")
    public Player updatePlayer(@RequestBody Player player){
        return playerService.updatePlayer(player);
    }
}
