package com.football.service;


import com.football.entity.PlayerEntity;
import com.football.pojo.Player;

public interface EntityConverterService {

    Player getPlayerByPlayerEntity(PlayerEntity playerEntity);

    PlayerEntity getPlayerEntityByPlayer(Player player);
}
