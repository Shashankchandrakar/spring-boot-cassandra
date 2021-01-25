package com.football.service;

import com.football.pojo.Player;

import java.util.UUID;

public interface PlayerService {

    Player getPlayerById(UUID id);

    Player createPlayer(Player player);

    void deletePlayer(UUID id);

    Player updatePlayer(Player player);
}
