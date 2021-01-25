package com.football.service.impl;

import com.football.entity.PlayerEntity;
import com.football.pojo.Player;
import com.football.service.EntityConverterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityConverterServiceImpl implements EntityConverterService {

    private final ModelMapper modelMapper;

    @Autowired
    public EntityConverterServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Player getPlayerByPlayerEntity(PlayerEntity playerEntity) {
        return modelMapper.map(playerEntity,Player.class);
    }

    @Override
    public PlayerEntity getPlayerEntityByPlayer(Player player) {
        return modelMapper.map(player,PlayerEntity.class);
    }
}
