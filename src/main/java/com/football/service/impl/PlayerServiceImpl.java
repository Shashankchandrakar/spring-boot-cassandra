package com.football.service.impl;

import com.football.entity.PlayerEntity;
import com.football.pojo.Player;
import com.football.repositry.PlayerRepository;
import com.football.service.EntityConverterService;
import com.football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final EntityConverterService entityConverterService;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, EntityConverterService entityConverterService) {
        this.playerRepository = playerRepository;
        this.entityConverterService = entityConverterService;
    }

    @Override
    public Player getPlayerById(UUID id) {
        Optional<PlayerEntity> optionalPlayerEntity = playerRepository.findById(id);
        if(!optionalPlayerEntity.isPresent()){
            throw new RuntimeException("Player Entity is not present for uuid :: "+id);
        }
        return entityConverterService.getPlayerByPlayerEntity(optionalPlayerEntity.get());
    }

    @Override
    public Player createPlayer(Player player) {
        PlayerEntity playerEntity = entityConverterService.getPlayerEntityByPlayer(player);
        return entityConverterService.getPlayerByPlayerEntity(playerRepository.save(playerEntity));
    }

    @Override
    public void deletePlayer(UUID id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player updatePlayer(Player player) {
        return createPlayer(player);
    }
}
