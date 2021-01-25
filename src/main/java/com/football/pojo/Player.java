package com.football.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class Player {
    private UUID playerId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Integer age;
}
