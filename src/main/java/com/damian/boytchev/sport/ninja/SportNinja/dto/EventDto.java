package com.damian.boytchev.sport.ninja.SportNinja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class EventDto {

    private UUID id;

    private Integer playersRequired;

    private String place;

    private String description;

    private Timestamp time;
}
