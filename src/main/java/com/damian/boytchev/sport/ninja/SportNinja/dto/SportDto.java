package com.damian.boytchev.sport.ninja.SportNinja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SportDto {

    private UUID id;

    private String name;

    private String description;

    private Integer numberOfPlayers;

    private String type;

    private String equipment;
}
