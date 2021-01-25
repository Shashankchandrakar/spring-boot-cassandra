package com.football.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("player")
@Data
public class PlayerEntity {

    @PrimaryKey
    private UUID playerId = UUID.randomUUID();

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

}
